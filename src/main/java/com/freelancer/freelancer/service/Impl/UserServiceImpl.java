package com.freelancer.freelancer.service.Impl;

import com.freelancer.freelancer.model.request.user.RegisterRequest;
import com.freelancer.freelancer.model.response.user.RegisterResponse;
import com.freelancer.freelancer.repository.UserRepository;
import com.freelancer.freelancer.service.UserService;
import com.freelancer.freelancer.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(userRepository.existsUserByEmail(s)){
            com.freelancer.freelancer.entity.User user = userRepository.findUserByEmail(s);
            return new User(user.getEmail(),user.getPassword(),new ArrayList<>());

        }
        throw new UsernameNotFoundException("user not found");
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        validationUtil.validate(registerRequest);
        com.freelancer.freelancer.entity.User user  = new com.freelancer.freelancer.entity.User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setName(registerRequest.getName());
        user.setCreated_at(new Date());
        user.setUpdated_at(user.getCreated_at());

        userRepository.save(user);
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setId(user.getId());
        registerResponse.setName(user.getName());
        registerResponse.setEmail(user.getEmail());
        return registerResponse;
    }
}
