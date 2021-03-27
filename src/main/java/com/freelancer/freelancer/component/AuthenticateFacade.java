package com.freelancer.freelancer.component;

import com.freelancer.freelancer.entity.User;
import org.springframework.security.core.Authentication;

public interface AuthenticateFacade {
    Authentication getAuthentication();
    User getAuthenticationUser();
}
