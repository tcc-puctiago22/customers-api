package br.com.gisa.customers.v1.model;

import br.com.gisa.customers.v1.constants.EmailType;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "email")
public class Email extends BasicModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -5004963806721766842L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "uuid", length = 36)
    private String uuid;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "email", length = 255)
    private String email;

    @Audited(withModifiedFlag = true)
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EmailType type;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;
}
