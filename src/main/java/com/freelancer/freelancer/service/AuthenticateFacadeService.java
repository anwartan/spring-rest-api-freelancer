package com.freelancer.freelancer.service;

import org.springframework.security.core.Authentication;

public interface AuthenticateFacadeService {
    Authentication getAuthentication();
}
