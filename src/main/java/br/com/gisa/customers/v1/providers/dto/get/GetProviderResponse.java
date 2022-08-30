package br.com.gisa.customers.v1.providers.dto.get;

import br.com.gisa.customers.v1.dto.CustomerDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetProviderResponse {

    private String registration;
    private CustomerDTO postCustomerDTO;
    private String uuidOccupational;
}
