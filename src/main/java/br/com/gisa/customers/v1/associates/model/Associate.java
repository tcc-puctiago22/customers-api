package br.com.gisa.customers.v1.associates.model;

import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.model.Customer;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity(name = "associate")
public class Associate extends BasicModel implements Serializable {

    private static final long serialVersionUID = -7138284003967144745L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "registration", nullable = false, length = 30)
    private String registration;

    @Column(name = "proposal_uuid", length = 36)
    private String proposalUuid;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "account_username", nullable = true, length = 36)
    private String accountUsername;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AssociateType type= AssociateType.OWNER;

    //@Column(name = "associate_id")
    //private int associateId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "associate_id", referencedColumnName = "id")
    private Set<Associate> accountRef;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
