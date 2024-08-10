package com.taskingcapgemini.infrastructure.config;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

public class NotNullValidator implements ConstraintValidator<NotNull, Object> {

    @Override
    public void initialize(NotNull notNull) {
       
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return value != null;  
    }
}

