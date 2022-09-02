package br.com.gisa.customers.v1.partners.model;

import br.com.gisa.customers.v1.model.Customer;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import br.com.gisa.customers.v1.providers.model.Provider;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name = "fantasy_name", nullable = false, length = 100)
    private String fantasyName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="provider_partner", joinColumns=
            {@JoinColumn(name="partner_id")}, inverseJoinColumns=
            {@JoinColumn(name="provider_id")})
    private Set<Provider> listProviders = new HashSet<>();
}
