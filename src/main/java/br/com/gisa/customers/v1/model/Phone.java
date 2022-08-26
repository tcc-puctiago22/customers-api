package br.com.gisa.customers.v1.model;

import br.com.gisa.customers.v1.constants.PhoneType;
import br.com.gisa.customers.v1.constants.Status;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "country", length = 3)
    private String country="+55";

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "email", length = 2)
    private Integer dd;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "phone", length = 11)
    private Integer phone;

    @Audited(withModifiedFlag = true)
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PhoneType type;


    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createDate;

    @Column(name = "user", nullable = false, length = 50)
    private String user="SYSTEM";
}
