package br.com.gisa.customers.v1.commons.filter;


import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Set;

public abstract class AbstractSpecification<T> implements Specification<T> {

    private final transient Set<SearchCriteria> searchCriteria;

    protected <R extends BasicFilter> AbstractSpecification(R request) {
        this.searchCriteria = request.toCriteria();
    }

    protected Predicate toPredicate(Root<T> root, CriteriaBuilder cb, Set<Predicate> predicates) {
        Predicate where = cb.and(predicates.toArray(new Predicate[0]));

        for (SearchCriteria criteria : searchCriteria)
            where = cb.and(where, criteria.getPredicate(root, cb));

        return where;
    }

}
