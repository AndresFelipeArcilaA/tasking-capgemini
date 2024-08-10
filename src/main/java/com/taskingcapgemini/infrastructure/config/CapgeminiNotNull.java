package com.taskingcapgemini.infrastructure.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullValidator.class)  // Se asocia con el validador
public @interface CapgeminiNotNull {

    String message() default "El campo no puede ser null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


