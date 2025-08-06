package vn.chuot96.authservicetbirpg2d.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.authservicetbirpg2d.comp.ForwardHelper;
import vn.chuot96.authservicetbirpg2d.dto.UserDTO;

@Service
@RequiredArgsConstructor
public class ForwardService {
    private final ForwardHelper forwardHelper;

    public Mono<?> forwardJwtIssApi(UserDTO user) {
        return forwardHelper.post(user, UserDTO.class);
    }
}
