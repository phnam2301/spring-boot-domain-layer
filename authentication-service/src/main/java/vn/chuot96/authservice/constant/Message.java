package vn.chuot96.authservice.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {
    REGISTER_SUCCESS("account registration successful!"),
    LOGIN_SUCCESS("account login successful!"),
    LINK_SUCCESS("account link successful!"),
    REMOVE_SUCCESS("account remove successful!"),
    ACCOUNT_INVALID("invalid account!!!");

    private final String message;
}
