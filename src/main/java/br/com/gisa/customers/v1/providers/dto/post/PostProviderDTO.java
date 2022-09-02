package br.com.gisa.customers.v1.providers.dto.post;

import br.com.gisa.customers.v1.dto.post.PostPFCustomerDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class PostProviderDTO {

    @NotNull(message = "Objeto customer é obrigatório!")
    private PostPFCustomerDTO customer;

    @NotNull(message = "o uuid Occupational é obrigatório@")
    private String uuidOccupational;
}
