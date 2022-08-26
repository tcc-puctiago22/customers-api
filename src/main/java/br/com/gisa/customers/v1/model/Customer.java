package br.com.gisa.customers.v1.model;

import br.com.gisa.customers.v1.constants.Status;
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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "given_name", nullable = false, length = 100)
    private String givenName;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createdDate;

    @Column(name = "user", nullable = false, length = 50)
    private String user="SYSTEM";

}
