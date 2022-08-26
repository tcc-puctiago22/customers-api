package br.com.gisa.customers.v1.providers.dto;

import br.com.gisa.customers.v1.commons.BasicFilter;
import br.com.gisa.customers.v1.commons.FilterAttribute;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@ToString
public class ProviderRequest extends BasicFilter {

    @FilterAttribute(name = "uuid")
    private String uuid;

    @FilterAttribute(name = "registration")
    private String registration;

}
