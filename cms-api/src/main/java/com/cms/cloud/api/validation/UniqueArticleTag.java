package com.cms.cloud.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UniqueArticleTagValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueArticleTag {

    String message() default "cannot be created from the same record.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
