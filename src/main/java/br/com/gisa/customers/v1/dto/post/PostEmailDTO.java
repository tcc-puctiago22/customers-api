package br.com.gisa.customers.v1.dto.post;

import br.com.gisa.customers.v1.constants.EmailType;
import br.com.gisa.customers.v1.constants.Status;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostEmailDTO {

    @NotNull
    private String email;
    @NotNull
    private EmailType type;
    private Status status = Status.ACTIVE;
}
