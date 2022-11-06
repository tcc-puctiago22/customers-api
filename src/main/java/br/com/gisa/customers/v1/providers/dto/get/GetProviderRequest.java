package br.com.gisa.customers.v1.providers.dto.get;

import br.com.gisa.customers.v1.commons.filter.BasicFilter;
import br.com.gisa.customers.v1.commons.filter.FilterAttribute;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@ToString
public class GetProviderRequest extends BasicFilter {

    @FilterAttribute(name = "uuid")
    private String uuid;

    @FilterAttribute(name = "registration")
    private String registration;

    @FilterAttribute(name = "occupation_description")
    private String occupationDescription;

    @FilterAttribute(name = "occupation_code")
    private String occupationCode;
}
