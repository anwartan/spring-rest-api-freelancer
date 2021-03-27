package com.freelancer.freelancer.component.impl;

import com.freelancer.freelancer.component.AuthenticateFacade;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.repository.UserRepository;
import com.freelancer.freelancer.service.AuthenticateFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AuthenticateFacadeImpl implements AuthenticateFacade {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public User getAuthenticationUser() {
        Authentication authentication = getAuthentication();

        User user = userRepository.findUserByEmail(authentication.getName());

        return user;
    }


}
