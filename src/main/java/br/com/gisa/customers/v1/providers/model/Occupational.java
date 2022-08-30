package br.com.gisa.customers.v1.providers.model;


import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "occupational")
public class Occupational extends BasicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "code", nullable = false, length = 15)
    private String code;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    @JsonBackReference
    private Provider provider;

}
