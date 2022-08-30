package br.com.gisa.customers.v1.model;

import br.com.gisa.customers.v1.constants.EmailType;
import br.com.gisa.customers.v1.constants.PhoneType;
import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.model.basic.BasicModel;
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
@Entity(name = "email")
public class Email extends BasicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Audited(withModifiedFlag = true)
    @Column(name = "email", length = 255)
    private String email;

    @Audited(withModifiedFlag = true)
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private EmailType type;
}
