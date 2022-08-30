package br.com.gisa.customers.v1.dto;

import br.com.gisa.customers.v1.constants.EmailType;
import br.com.gisa.customers.v1.constants.Status;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    @NotNull
    private String email;
    @NotNull
    private EmailType type;
    private Status status;
}
