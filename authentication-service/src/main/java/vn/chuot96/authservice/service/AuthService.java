package vn.chuot96.authservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.authservice.anno.BeforeImplement;
import vn.chuot96.authservice.dto.RequestDTO;
import vn.chuot96.authservice.dto.UserDTO;

import java.util.Collections;
import java.util.List;

@Service
@BeforeImplement
@RequiredArgsConstructor
public class AuthService {
    private final ForwardService forwardService;
    private final AccService accService;
    private final AppService appService;
    private final AccAppService accAppService;

    public Mono<ResponseEntity<?>> handleGuest(RequestDTO request) {
        String credential = request.provider() + request.subject();
        return accService
                .insertGuestAcc(credential)
                .flatMap(accId -> Mono.zip(Mono.just(accId), appService.findIdByCode(request.objectCode())))
                .flatMap(tuple ->
                        accAppService.insertAccApp(tuple.getT1(), tuple.getT2()).thenReturn(tuple.getT1()))
                .flatMap(accId -> forwardService.forwardJwtIssApi(
                        new UserDTO(request.provider(), request.subject(), "default", List.of("default"))))
                .map(ResponseEntity::ok);
    }

    public Mono<ResponseEntity<?>> handleRegister(RequestDTO request) {
        String credential = request.provider() + request.subject();
        Mono<Long> accMono = accService.findIdByCredential(credential);
        Mono<Long> appMono = appService.findIdByCode(request.objectCode());
        return accAppService
                .findIdByAccCredentialAndAppCode(credential, request.objectCode())
                .switchIfEmpty(Mono.zip(accMono, appMono)
                        .flatMap(tuple -> {
                            Long accId = tuple.getT1();
                            Long appId = tuple.getT2();
                            return accAppService.insertAccApp(accId, appId);
                        })
                        .then(Mono.just(-1L)))
                .thenReturn(ResponseEntity.ok(credential));
    }

    public Mono<ResponseEntity<?>> handleLink(RequestDTO request) {
        return accService
                .updateCredential(request.objectCode(), request.provider() + request.subject())
                .flatMap(accId -> forwardService.forwardJwtIssApi(new UserDTO(
                        request.provider(), request.subject(), "default", Collections.singletonList("default"))))
                .map(ResponseEntity::ok);
    }

    public Mono<Void> handleRemove(RequestDTO request) {
        return accAppService.deleteByAccCredentialAndAppCode(
                request.provider() + request.subject(), request.objectCode());
    }
}
