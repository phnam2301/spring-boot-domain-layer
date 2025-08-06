package vn.chuot96.authservicetbirpg2d.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("accounts")
public class Acc {
    @Id
    private Long id;

    private String code;
    private Boolean status;
    private String credential;
}
