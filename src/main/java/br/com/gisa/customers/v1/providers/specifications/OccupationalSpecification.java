package br.com.gisa.customers.v1.providers.specifications;
import br.com.gisa.customers.v1.commons.filter.AbstractSpecification;
import br.com.gisa.customers.v1.providers.dto.get.GetOccupationalRequest;
import br.com.gisa.customers.v1.providers.model.Occupational;
import javax.persistence.criteria.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;

public class OccupationalSpecification extends AbstractSpecification<Occupational> {

    public OccupationalSpecification(GetOccupationalRequest request) {
            super(request);
    }

    @Override
    public Predicate toPredicate(Root<Occupational> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        return super.toPredicate(root, cb, new HashSet<>());
    }

}