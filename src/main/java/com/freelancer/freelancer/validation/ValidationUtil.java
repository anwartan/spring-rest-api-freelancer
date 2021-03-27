package com.freelancer.freelancer.validation;


import com.freelancer.freelancer.model.request.base.BaseRequest;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;


@Component
public class ValidationUtil {

    private Validator validator;

    public ValidationUtil(Validator validator) {
        this.validator = validator;
    }

    public void validate(BaseRequest any) {
        Set<ConstraintViolation<BaseRequest>> result = validator.validate(any);
        if (result.size() != 0) {
            throw new ConstraintViolationException(result);
        }

    }


}
