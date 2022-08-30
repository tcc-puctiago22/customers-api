package br.com.gisa.customers.v1.model;

import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.model.basic.BasicModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "customer")
public class Customer extends BasicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "given_name", nullable = false, length = 100)
    private String givenName;

}
