package vn.chuot96.authservicetbirpg2d.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("applications")
public class App {
    @Id
    private Long id;

    private String code;
    private boolean status;
}
