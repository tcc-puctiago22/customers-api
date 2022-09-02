package br.com.gisa.customers.v1.partners.dto.put;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@ToString
public class PutPatnerDTO {

    private String uuid;

    @NotEmpty
    private Set<PuTProviderDTO> listProviders;
}
