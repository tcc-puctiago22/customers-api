package br.com.gisa.customers.v1.providers.dto.get;

import br.com.gisa.customers.v1.commons.exceptions.ExceptionCodes;
import br.com.gisa.customers.v1.commons.exceptions.ResponseCodeException;
import br.com.gisa.customers.v1.commons.filter.BasicFilter;
import br.com.gisa.customers.v1.commons.filter.FilterAttribute;
import br.com.gisa.customers.v1.commons.filter.Operator;
import br.com.gisa.customers.v1.constants.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Sort;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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

    @FilterAttribute(name = "createdDate", operator = Operator.DATE_TIME_GE)
    private LocalDateTime createdDate;

    public GetOccupationalRequest() {
        super();
        setOrderBy(Sort.Direction.ASC);
        setSortBy(Set.of("createdDate"));
    }

    @Override
    public void setSortBy(Set<String> sortBy) {
        sortBy = sortBy.stream().map(s -> s.equals("createdDate") ? "createdDate" : s).collect(Collectors.toSet());
        super.setSortBy(sortBy);
    }

    /**
     * Spring will use this method to deserialize dateFrom
     */
    @SuppressWarnings("unused")
    public void setCreatedDate(String dateFrom) {
        this.createdDate = LocalDate.parse(dateFrom).atStartOfDay();
    }

}
