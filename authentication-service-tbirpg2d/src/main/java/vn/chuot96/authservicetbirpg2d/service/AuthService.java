package vn.chuot96.authservicetbirpg2d.service;

import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.authservicetbirpg2d.dto.LinkRequestDTO;
import vn.chuot96.authservicetbirpg2d.dto.RequestDTO;
import vn.chuot96.authservicetbirpg2d.dto.UserDTO;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final ForwardService forwardService;
    private final AccService accService;
    private final AppService appService;
    private final AccAppService accAppService;

    public Mono<ResponseEntity<?>> handleGuest(RequestDTO request) {
        String credential = request.provider() + request.subject();
        Mono<Long> accMono = accService.findIdByCredential(credential);
        Mono<Long> appMono = appService.findIdByCode(request.appCode());
        return accService
                .insertGuestAcc(credential)
                .flatMap(result -> Mono.zip(accMono, appMono).flatMap(tuple -> {
                    Long accId = tuple.getT1();
                    Long appId = tuple.getT2();
                    return accAppService.insertAccApp(accId, appId).thenReturn(result);
                }))
                .flatMap(account -> forwardService.forwardJwtIssApi(new UserDTO(
                        request.provider(), request.subject(), "default", Collections.singletonList("default"))))
                .map(ResponseEntity::ok);
    }

    public Mono<ResponseEntity<?>> handleLogin(RequestDTO request) {
        String credential = request.provider() + request.subject();
        Mono<Long> accMono = accService.findIdByCredential(credential);
        Mono<Long> appMono = appService.findIdByCode(request.appCode());
        return accAppService
                .findIdByAccCredentialAndAppCode(credential, request.appCode())
                .switchIfEmpty(Mono.zip(accMono, appMono)
                        .flatMap(tuple -> {
                            Long accId = tuple.getT1();
                            Long appId = tuple.getT2();
                            return accAppService.insertAccApp(accId, appId);
                        })
                        .then(Mono.just(-1L)))
                .thenReturn(ResponseEntity.ok(credential));
    }

    public Mono<ResponseEntity<?>> handleLink(LinkRequestDTO request) {
        return accService
                .updateCredential(request.credential(), request.provider() + request.subject())
                .flatMap(account -> forwardService.forwardJwtIssApi(new UserDTO(
                        request.provider(), request.subject(), "default", Collections.singletonList("default"))))
                .map(ResponseEntity::ok);
    }

    public Mono<Void> handleRemove(RequestDTO request) {
        return accAppService.deleteByAccCredentialAndAppCode(request.provider() + request.subject(), request.appCode());
    }
}
