package br.com.gisa.customers.v1.model;

import br.com.gisa.customers.v1.constants.UF;
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
@Entity(name = "address")
public class Address extends BasicModel implements Serializable {

    private static final long serialVersionUID = 1814668000698952350L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "uuid", length = 36)
    private String uuid;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "postcode", length = 9)
    private String postcode;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "street_name", length = 255)
    private String streetName;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "street_number", length = 6)
    private Integer streetNumber;

    @Audited(withModifiedFlag = true)
    @Column(name = "complement", length = 100)
    private String complement;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "district", length = 100)
    private String district;

    @Audited(withModifiedFlag = true)
    @Column(name = "country", length = 100)
    private String country = "BRASIL";

    @NotNull
    @Column(name = "uf", nullable = false)
    @Enumerated(EnumType.STRING)
    private UF uf;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "city", length = 100)
    private String city;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

}
