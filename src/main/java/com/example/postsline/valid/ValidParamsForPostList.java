package com.example.postsline.valid;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValidParamsForPostListValidator.class)
@Target({METHOD, CONSTRUCTOR, ANNOTATION_TYPE, FIELD})
@Retention(value = RUNTIME)
public @interface ValidParamsForPostList {

    String message() default "valid method createPost format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
