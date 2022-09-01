package com.cms.cloud.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {UniqueLikedValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueLiked {

    String message() default "More than one like cannot be sent to the same article";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
