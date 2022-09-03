package br.com.gisa.customers.v1.providers.model;

import br.com.gisa.customers.v1.model.Customer;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import br.com.gisa.customers.v1.partners.model.Partner;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity(name = "provider")
public class Provider extends BasicModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1399051303176191347L;// (prestador)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "registration", nullable = false, length = 20)
    private String registration ;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="provider_occupational", joinColumns=
            {@JoinColumn(name="provider_id")}, inverseJoinColumns=
            {@JoinColumn(name="occupational_id")})
    private Set<Occupational> listOccupational = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToMany(mappedBy = "listProviders")
    Set<Partner> listPartners = new HashSet<>();

}
