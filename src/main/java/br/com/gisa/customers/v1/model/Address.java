package br.com.gisa.customers.v1.model;

import br.com.gisa.customers.v1.constants.UF;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    private String country;

    @Audited(withModifiedFlag = true)
    @Column(name = "country_desc", length = 255) // ????
    private String countryDesc = "BRASIL";

    @NotNull
    @Column(name = "uf", nullable = false)
    @Enumerated(EnumType.STRING)
    private UF uf;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "uf_desc", length = 100)
    private String ufDesc;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "city", length = 100)
    private String city;

    @Audited(withModifiedFlag = true)
    @UpdateTimestamp
    @Column(name = "updatedat")
    private LocalDateTime updatedAt;

    @Audited(withModifiedFlag = true)
    @Column(name = "createdat")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

}
