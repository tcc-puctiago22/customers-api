package br.com.gisa.customers.v1.partners.model;

import br.com.gisa.customers.v1.model.basic.BasicModel;
import br.com.gisa.customers.v1.providers.model.Provider;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Entity(name = "partner")
public class Partner extends BasicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "registration", nullable = false, length = 20)
    private String registration;

    @ManyToMany(mappedBy = "partners")
    private Set<Provider> employees = new HashSet<>();
}
