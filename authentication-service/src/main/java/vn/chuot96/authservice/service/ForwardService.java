package vn.chuot96.authservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.authservice.compo.ForwardHelper;
import vn.chuot96.authservice.dto.UserDTO;

@Service
@RequiredArgsConstructor
public class ForwardService {
    private final ForwardHelper forwardHelper;

    public Mono<?> forwardJwtIssApi(UserDTO user) {
        return forwardHelper.post(user, UserDTO.class);
    }
}
