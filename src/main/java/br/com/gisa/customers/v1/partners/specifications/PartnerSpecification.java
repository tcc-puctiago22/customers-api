package br.com.gisa.customers.v1.partners.specifications;

import br.com.gisa.customers.v1.model.Address;
import br.com.gisa.customers.v1.model.Customer;
import br.com.gisa.customers.v1.partners.model.Partner;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PartnerSpecification {

    public Specification<Partner> hasUf(String city) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<Predicate>();

            Join<Customer, Partner> provider = root.join("customer");
            Join<Address, Customer> customer = provider.join("addresses");
            list.add(criteriaBuilder.equal(customer.get("city"), city));

            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        };
    }
}
