package br.com.gisa.customers.v1.providers.dto.post;

import br.com.gisa.customers.v1.dto.post.PostPFCustomerDTO;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString
public class PostProviderDTO {

    @NotNull(message = "Objeto customer é obrigatório!")
    private PostPFCustomerDTO customer;

    @NotEmpty(message = "listOccupational é obrigatório@")
    private Set<String> listOccupational;
}
