package br.com.gisa.customers.v1.associates.dto.post;

import br.com.gisa.customers.v1.dto.post.PostPFCustomerDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAssociateDTO {

    private String registration;
    private String accountUuid;
    private PostPFCustomerDTO customer;
}
