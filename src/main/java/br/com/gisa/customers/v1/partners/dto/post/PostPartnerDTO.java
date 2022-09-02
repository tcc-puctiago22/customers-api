package br.com.gisa.customers.v1.partners.dto.post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@ToString
public class PostPartnerDTO {

    @NotNull(message = "o uuid fantasyName é obrigatório!")
    private String fantasyName;

    @NotNull(message = "Objeto customer é obrigatório!")
    private PostPJCustomerDTO customer;

}
