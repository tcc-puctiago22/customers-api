package br.com.gisa.customers.v1.providers.model;

import br.com.gisa.customers.v1.constants.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
@Entity(name = "provider")
public class Provider { // (prestador)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, length = 36)
    private String uuid;

    @Column(name = "registration", nullable = false, length = 20)
    private String registration;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(mappedBy = "provider", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private Occupational occupational;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createdDate;

    @Column(name = "user", nullable = false, length = 50)
    private String user="SYSTEM";

}
