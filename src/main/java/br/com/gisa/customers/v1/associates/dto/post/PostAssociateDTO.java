package br.com.gisa.customers.v1.associates.dto.post;

import br.com.gisa.customers.v1.associates.model.AssociateType;
import br.com.gisa.customers.v1.dto.post.PostPFCustomerDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostAssociateDTO {

    private String registration;
    private String accountUsername;
    private String proposalUuid;
    private AssociateType type;
    private LocalDate birthDate;
    private PostPFCustomerDTO customer;
}
