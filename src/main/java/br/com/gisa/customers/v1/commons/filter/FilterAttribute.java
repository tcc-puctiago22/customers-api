package br.com.gisa.customers.v1.commons.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FilterAttribute {

    String name() default "";

    Operator operator() default Operator.EQUAL;

}
