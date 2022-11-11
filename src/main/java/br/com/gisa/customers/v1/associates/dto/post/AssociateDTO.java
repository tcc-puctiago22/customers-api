package br.com.gisa.customers.v1.associates.dto.post;


import br.com.gisa.customers.v1.associates.model.AssociateType;
import br.com.gisa.customers.v1.dto.CustomerDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AssociateDTO {

    private String uuid;
    private LocalDate birthDate;
    private String registration;
    private String accountUsername;
    private String proposalUuid;
    private AssociateType type;
    private CustomerDTO customer;

    private String status;
    private LocalDateTime updateDate;
    private LocalDateTime createdDate;
    private String user;

}
