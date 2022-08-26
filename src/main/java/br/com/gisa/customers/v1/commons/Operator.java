package br.com.gisa.customers.v1.commons;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;

public enum Operator {

    EQUAL {
        @Override
        Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.equal(root.get(key), value);
        }
    },
    LIKE {
        @Override
        Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.like(root.get(key), "%" + value + "%");
        }
    },
    IN {
        @Override
        Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value) {
            return root.get(key).in(value);
        }
    },
    NUMBER_GE {
        @Override
        Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.ge(root.get(key), (Number) value);
        }
    },
    NUMBER_LE {
        @Override
        Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.le(root.get(key), (Number) value);
        }
    },
    DATE_TIME_GE {
        @Override
        Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.greaterThanOrEqualTo(root.get(key), (LocalDateTime) value);
        }
    },
    DATE_TIME_LE {
        @Override
        Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.lessThanOrEqualTo(root.get(key), (LocalDateTime) value);
        }
    },
    DATE_GE {
        @Override
        Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.greaterThanOrEqualTo(root.get(key), (LocalDate) value);
        }
    },
    DATE_LE {
        @Override
        Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value) {
            return builder.lessThanOrEqualTo(root.get(key), (LocalDate) value);
        }
    };

    abstract Predicate getPredicate(Root<?> root, CriteriaBuilder builder, String key, Object value);

}

