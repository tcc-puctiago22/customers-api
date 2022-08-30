package br.com.gisa.customers.v1.providers.dto.post;

import br.com.gisa.customers.v1.dto.post.PostCustomerDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostProviderDTO {
    @NotNull
    private String registration;
    @NotNull
    private PostCustomerDTO postCustomerDTO;
    @NotNull
    private String uuidOccupational;
}
