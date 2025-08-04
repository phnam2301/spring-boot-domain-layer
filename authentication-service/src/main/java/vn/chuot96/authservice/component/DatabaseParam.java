package vn.chuot96.authservice.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "database")
public class DatabaseParam {
    private String host;
    private String port;
    private String username;
    private String password;
    private String schema;
}
