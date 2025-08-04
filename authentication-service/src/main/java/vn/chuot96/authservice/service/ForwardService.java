package vn.chuot96.authservice.service;

import static vn.chuot96.authservice.constant.Query.*;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.authservice.component.DatabaseParam;
import vn.chuot96.authservice.component.ForwardHelper;
import vn.chuot96.authservice.dto.AuthDTO;
import vn.chuot96.authservice.dto.UserRequestDTO;

@Service
@RequiredArgsConstructor
public class ForwardService {
    private final DatabaseParam database;

    private final ForwardHelper forwardHelper;

    public Mono<?> forwardAuthRequest(AuthDTO auth) {
        return forwardHelper.post(
                "database-connector-api", "/db/sql/mysql", "forward-auth-request", auth, AuthDTO.class);
    }

    public Mono<?> forwardFindUser(UserRequestDTO user) {
        return forwardAuthRequest(
                new AuthDTO(database, FIND_USER.getQuery(), List.of(user.provider(), user.subject())));
    }

    public Mono<?> forwardInsertUser(UserRequestDTO user) {
        return forwardAuthRequest(
                new AuthDTO(database, INSERT_USER.getQuery(), List.of(user.provider(), user.subject())));
    }

    public Mono<?> forwardUpdateUser(UserRequestDTO user) {
        return forwardAuthRequest(
                new AuthDTO(database, UPDATE_USER.getQuery(), List.of(user.provider(), user.subject())));
    }

    public Mono<?> forwardDeleteUser(UserRequestDTO user) {
        return forwardAuthRequest(
                new AuthDTO(database, DELETE_USER.getQuery(), List.of(user.provider(), user.subject())));
    }
}
