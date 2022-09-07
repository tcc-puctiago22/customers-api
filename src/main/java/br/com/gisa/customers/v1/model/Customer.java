package br.com.gisa.customers.v1.model;

import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import br.com.gisa.customers.v1.partners.model.Partner;
import br.com.gisa.customers.v1.providers.model.Provider;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "customer")
public class Customer extends BasicModel implements Serializable {

    private static final long serialVersionUID = 8994644126379071859L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36,unique = true)
    private String uuid ;

    @Column(name = "document", nullable = false, length = 15,unique = true)
    private String document;

    @Column(name = "person_type", nullable = false, length = 2,unique = true)
    private String personType;

    @Column(name = "given_name", nullable = false, length = 100)
    private String givenName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Email> emails = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Phone> phones = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Set<Address> addresses = new HashSet<>();

    @OneToOne(mappedBy = "customer")
    private Provider provider;

    @OneToOne(mappedBy = "customer")
    private Partner partner;

    @OneToOne(mappedBy = "customer")
    private Associate associate;

}
