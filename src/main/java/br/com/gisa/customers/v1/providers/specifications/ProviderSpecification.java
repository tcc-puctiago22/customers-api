package br.com.gisa.customers.v1.providers.specifications;

import br.com.gisa.customers.v1.providers.dto.get.GetProviderRequest;
import br.com.gisa.customers.v1.providers.model.Occupational;
import br.com.gisa.customers.v1.providers.model.Provider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;

import static org.springframework.data.jpa.domain.Specification.*;

@Component
public class ProviderSpecification extends BaseSpecification<Provider, GetProviderRequest> {

    public  Specification<Provider> hasOccupationDescrition(String description) {
        return (root, query, criteriaBuilder) -> {
            Join<Occupational, Provider> provider = root.join("listOccupational");
            return criteriaBuilder.equal(provider.get("description"), description);
        };
    }
    @Override
    public Specification<Provider> getFilter(GetProviderRequest request) {
        return (root, query, cb) -> {
            query.distinct(true); //Important because of the join in the addressAttribute specifications
            return where(firstRegistrationContains(request.getRegistration()))
                    .toPredicate(root, query, cb);
        };
    }

    private Specification<Provider> firstRegistrationContains(String registration) {
        return providerAttributeContains("registration", registration);
    }
    private Specification<Provider> providerAttributeContains(String attribute, String value) {
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