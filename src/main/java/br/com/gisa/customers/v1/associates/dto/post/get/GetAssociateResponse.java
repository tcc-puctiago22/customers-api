package br.com.gisa.customers.v1.associates.dto.post.get;


import br.com.gisa.customers.v1.associates.model.AssociateType;
import br.com.gisa.customers.v1.dto.CustomerDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetAssociateResponse {

    private String uuid;
    private String registration;
    private String planUuid;
    private String accountUsername;
    private String proposalUuid;
    private AssociateType type;
    private CustomerDTO customer;

    private String status;
    private LocalDateTime updateDate;
    private LocalDateTime createdDate;
    private String user;
}
