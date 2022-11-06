package br.com.gisa.customers.v1.partners.dto;

import br.com.gisa.customers.v1.commons.filter.BasicFilter;
import br.com.gisa.customers.v1.commons.filter.FilterAttribute;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetPartnerRequest extends BasicFilter {

    @FilterAttribute(name = "city")
    private String city;
}
