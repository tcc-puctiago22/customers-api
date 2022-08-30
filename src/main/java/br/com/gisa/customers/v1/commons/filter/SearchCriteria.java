package br.com.gisa.customers.v1.commons.filter;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Getter
@AllArgsConstructor
public class SearchCriteria {

    private final String key;

    private final Operator operator;

    private final Object value;

    public Predicate getPredicate(Root<?> root, CriteriaBuilder builder) {
        return operator.getPredicate(root, builder, key, value);
    }

}
