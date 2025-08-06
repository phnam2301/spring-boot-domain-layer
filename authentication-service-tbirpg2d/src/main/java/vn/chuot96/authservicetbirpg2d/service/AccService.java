package vn.chuot96.authservicetbirpg2d.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.authservicetbirpg2d.entity.Acc;
import vn.chuot96.authservicetbirpg2d.repository.AccRepository;
import vn.chuot96.authservicetbirpg2d.util.CodeGenerator;

@Service
@RequiredArgsConstructor
public class AccService {
    private final AccRepository accRepository;

    public Mono<Long> findIdByCredential(String credential) {
        return accRepository.findIdByCredential(credential);
    }

    public Mono<?> insertGuestAcc(String credential) {
        return accRepository.save(Acc.builder()
                .code(CodeGenerator.generate())
                .credential(credential)
                .build());
    }

    public Mono<Acc> updateCredential(String guest, String credential) {
        return accRepository.findByCredential(guest).flatMap(acc -> {
            acc.setCredential(credential);
            return accRepository.save(acc);
        });
    }
}
