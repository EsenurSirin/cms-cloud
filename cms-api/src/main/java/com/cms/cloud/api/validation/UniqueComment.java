package com.cms.cloud.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UniqueCommentValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueComment {

    String message() default "A user cannot add more than 10 comments to a comment!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
