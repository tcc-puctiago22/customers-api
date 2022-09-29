package br.com.gisa.customers.v1.associates.specifications;

import br.com.gisa.customers.v1.associates.dto.post.get.GetAssocieateRequest;
import br.com.gisa.customers.v1.associates.model.Associate;
import br.com.gisa.customers.v1.commons.filter.AbstractSpecification;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;

public class AssocieateSpecification extends AbstractSpecification<Associate> {

    public AssocieateSpecification(GetAssocieateRequest request) {
        super(request);
    }

    @Override
    public Predicate toPredicate(Root<Associate> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        return super.toPredicate(root, cb, new HashSet<>());
    }

}