package com.freelancer.freelancer.service;

import com.freelancer.freelancer.model.request.user.RegisterRequest;
import com.freelancer.freelancer.model.response.user.RegisterResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    RegisterResponse register(RegisterRequest registerRequest);
}
