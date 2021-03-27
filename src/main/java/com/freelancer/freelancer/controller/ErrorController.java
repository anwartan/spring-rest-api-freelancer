package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.Exception.InternalServeErrorException;
import com.freelancer.freelancer.Exception.NotAuthorizeException;
import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.model.response.base.WebResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {


    @ExceptionHandler(value = ConstraintViolationException.class)
    public WebResponse<String> validationHandler (ConstraintViolationException constraintViolationException){
        WebResponse<String> result = new WebResponse<>();
        result.setCode(400);
        result.setStatus("BAD REQUEST");
        result.setData(constraintViolationException.getMessage());
        return result;
    }

    @ExceptionHandler(value = NotFoundException.class)
    public WebResponse<String> notFound(NotFoundException notFoundException){
        WebResponse<String> result = new WebResponse<>();
        result.setCode(404);
        result.setStatus("NOT FOUND");
        if (notFoundException.getMessage()==null){
            result.setData("NOT FOUND");

        }else{
            result.setData(notFoundException.getMessage());
        }
        return result;

    }

    @ExceptionHandler(value = NotAuthorizeException.class)
    public WebResponse<String> authorizationError(NotAuthorizeException notAuthorizeException){
        WebResponse<String> result = new WebResponse<>();
        result.setCode(401);
        result.setStatus("Internal Server Error");
        if (notAuthorizeException.getMessage()==null){
            result.setData("Internal Server Error");

        }else{
            result.setData(notAuthorizeException.getMessage());
        }
        return result;
    }

    @ExceptionHandler(value = InternalServeErrorException.class)
    public WebResponse<String> internalServerError(InternalServeErrorException internalServerErrorException){
        WebResponse<String> result = new WebResponse<>();
        result.setCode(500);
        result.setStatus("Internal Server Error");
        if (internalServerErrorException.getMessage()==null){
            result.setData("Internal Server Error");

        }else{
            result.setData(internalServerErrorException.getMessage());
        }
        return result;
    }
}
