package br.com.gisa.customers.v1.commons.helper;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CNPJValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SisaCNPJValidator {

    String message() default "Documento Inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}