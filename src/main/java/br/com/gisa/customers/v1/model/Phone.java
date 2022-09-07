package br.com.gisa.customers.v1.model;

import br.com.gisa.customers.v1.constants.PhoneType;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "phone")
public class Phone extends BasicModel implements Serializable {

    private static final long serialVersionUID = -5616337837256350880L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "uuid", length = 36)
    private String uuid;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "country", length = 3)
    private String country="+55";

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "ddd", length = 2)
    private Integer ddd;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @Audited(withModifiedFlag = true)
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

}
