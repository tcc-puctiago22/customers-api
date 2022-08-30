package br.com.gisa.customers.v1.dto.post;

import br.com.gisa.customers.v1.constants.PhoneType;
import br.com.gisa.customers.v1.constants.Status;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostPhoneDTO {

    private String country="+55";
    @NotNull
    private Integer dd;
    @NotNull
    private Integer phone;
    @NotNull
    private PhoneType type;
    private Status status = Status.ACTIVE;
    private String user="SYSTEM";
}
