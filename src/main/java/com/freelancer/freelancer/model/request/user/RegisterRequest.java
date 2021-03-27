package com.freelancer.freelancer.model.request.user;

import com.freelancer.freelancer.model.request.base.BaseRequest;
import com.freelancer.freelancer.validation.EmailConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterRequest extends BaseRequest {

    @NotBlank
    @Email
    @EmailConstraint
    private String email;

    @NotBlank
    @Size(min = 6, max = 12)
    private String password;

    @NotBlank
    private String name;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
