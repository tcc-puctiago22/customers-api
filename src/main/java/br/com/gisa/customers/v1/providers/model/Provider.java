package br.com.gisa.customers.v1.providers.model;

import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import br.com.gisa.customers.v1.partners.model.Partner;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Entity(name = "provider")
public class Provider extends BasicModel { // (prestador)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "registration", nullable = false, length = 20)
    private String registration;

    @OneToOne(mappedBy = "provider", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Occupational occupational;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Provider_partner",
            joinColumns = { @JoinColumn(name = "provider_id") },
            inverseJoinColumns = { @JoinColumn(name = "partner_id") }
    )
    Set<Partner> projects = new HashSet<>();
}
