package com.freelancer.freelancer.validation;


import com.freelancer.freelancer.validation.Validator.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {
    String message() default "Email have to unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
