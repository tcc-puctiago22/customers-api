package br.com.gisa.customers.v1.partners.dto.post;

import br.com.gisa.customers.v1.constants.Status;
import br.com.gisa.customers.v1.dto.CustomerDTO;
import br.com.gisa.customers.v1.model.Customer;
import br.com.gisa.customers.v1.providers.dto.OccupationalDTO;
import br.com.gisa.customers.v1.providers.dto.ProviderDTO;
import br.com.gisa.customers.v1.providers.model.Provider;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PartnerDTO {

    private String uuid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String registration;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fantasyName;
    private String site;
    private CustomerDTO customer;
    private Set<ProviderDTO> listProviders;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String user;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;
    private Status status;
}
