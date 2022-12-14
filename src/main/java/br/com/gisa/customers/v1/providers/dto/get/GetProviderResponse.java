package br.com.gisa.customers.v1.providers.dto.get;

import br.com.gisa.customers.v1.dto.CustomerDTO;
import br.com.gisa.customers.v1.providers.dto.OccupationalDTO;
import br.com.gisa.customers.v1.providers.model.Occupational;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetProviderResponse {

    private String uuid;
    private String registration;
    private CustomerDTO customer;
    private String uuidOccupational;
    private LocalDate birthDate;
    private Set<OccupationalDTO> listOccupational;


}
