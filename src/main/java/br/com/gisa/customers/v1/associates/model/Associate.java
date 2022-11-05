package br.com.gisa.customers.v1.associates.model;

import br.com.gisa.customers.v1.model.Customer;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

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

    @Column(name = "plan_uuid", length = 36)
    private String planUuid;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "account_uuid", nullable = false, length = 36)
    private String accountUuid;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
