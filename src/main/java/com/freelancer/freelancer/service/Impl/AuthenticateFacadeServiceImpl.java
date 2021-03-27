package com.freelancer.freelancer.service.Impl;

import com.freelancer.freelancer.service.AuthenticateFacadeService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateFacadeServiceImpl implements AuthenticateFacadeService {
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
