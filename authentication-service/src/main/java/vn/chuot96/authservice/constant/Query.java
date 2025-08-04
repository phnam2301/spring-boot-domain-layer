package vn.chuot96.authservice.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Query {
    FIND_USER("SELECT provider, subject FROM users WHERE provider = ? AND subject = ?"),
    INSERT_USER("INSERT INTO users (provider, subject) VALUES (?, ?)"),
    UPDATE_USER("UPDATE users SET provider = ?, subject = ? WHERE provider = ? AND subject = ?"),
    DELETE_USER("DELETE FROM users WHERE provider = ? AND subject = ?");

    private final String query;
}
