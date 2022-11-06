package br.com.gisa.customers.v1.partners.dto;

import br.com.gisa.customers.v1.dto.CustomerDTO;
import br.com.gisa.customers.v1.providers.dto.OccupationalDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetPartnerResponse {

    private String uuid;
    private String registration;
    private CustomerDTO customer;
    private String fantasyName;
    private String site;
    private Set<OccupationalDTO> listOccupational;
}
