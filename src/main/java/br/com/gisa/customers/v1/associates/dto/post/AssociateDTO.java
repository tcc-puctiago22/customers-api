package br.com.gisa.customers.v1.associates.dto.post;


import br.com.gisa.customers.v1.dto.CustomerDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AssociateDTO {

    private String registration;
    private String planUuid;
    private String accountUuid;
    private CustomerDTO customer;

    private String status;
    private LocalDateTime updateDate;
    private LocalDateTime createdDate;
    private String user;

}
