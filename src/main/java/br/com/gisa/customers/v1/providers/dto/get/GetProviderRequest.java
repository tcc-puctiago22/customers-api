package br.com.gisa.customers.v1.providers.dto.get;

import br.com.gisa.customers.v1.commons.BasicFilter;
import br.com.gisa.customers.v1.commons.FilterAttribute;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetProviderRequest extends BasicFilter {

    @FilterAttribute(name = "uuid")
    private String uuid;

    @FilterAttribute(name = "registration")
    private String registration;

}
