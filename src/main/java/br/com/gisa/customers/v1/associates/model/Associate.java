package br.com.gisa.customers.v1.associates.model;

import br.com.gisa.customers.v1.model.basic.BasicModel;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Entity(name = "associate")
public class Associate extends BasicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "registration", nullable = false, length = 20)
    private String registration;

    @Column(name = "plan_uuid", nullable = false, length = 36)
    private String plan_uuid;
}
