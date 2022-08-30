package br.com.gisa.customers.v1.providers.dto.get;

import br.com.gisa.customers.v1.commons.BasicFilter;
import br.com.gisa.customers.v1.commons.FilterAttribute;
import br.com.gisa.customers.v1.constants.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
public class GetOccupationalRequest extends BasicFilter {

    @FilterAttribute(name = "uuid")
    private String uuid;

    @FilterAttribute(name = "description")
    private String description;

    @FilterAttribute(name = "code")
    private String code;

    @FilterAttribute(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
