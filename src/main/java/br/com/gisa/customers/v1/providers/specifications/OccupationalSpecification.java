package br.com.gisa.customers.v1.providers.specifications;

import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalRequest;
import br.com.gisa.customers.v1.providers.dto.get.GetProviderRequest;
import br.com.gisa.customers.v1.providers.model.Occupational;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class OccupationalSpecification extends BaseSpecification<Occupational, GetOccupationalRequest> {

    @Override
    public Specification<Occupational> getFilter(GetOccupationalRequest request) {
        return (root, query, cb) -> {
            query.distinct(true); //Important because of the join in the addressAttribute specifications
            return where(firstRegistrationContains(request.getCode())
            ).and(firstRegistrationContains(request.getCode()))
                    .toPredicate(root, query, cb);
        };

    }

    private Specification<Occupational> firstRegistrationContains(String code) {
        return providerAttributeContains("code", code);
    }
    private Specification<Occupational> providerAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get(attribute)),
                    containsLowerCase(value)
            );
        };
    }

}