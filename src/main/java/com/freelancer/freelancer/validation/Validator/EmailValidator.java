package com.freelancer.freelancer.validation.Validator;

import com.freelancer.freelancer.repository.UserRepository;
import com.freelancer.freelancer.validation.EmailConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint,String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsUserByEmail(s);
    }
}
