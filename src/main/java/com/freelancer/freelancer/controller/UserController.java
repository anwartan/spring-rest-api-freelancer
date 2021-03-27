package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.Exception.NotAuthorizeException;
import com.freelancer.freelancer.component.AuthenticateFacade;
import com.freelancer.freelancer.entity.User;
import com.freelancer.freelancer.model.request.user.LoginRequest;
import com.freelancer.freelancer.model.request.user.RegisterRequest;
import com.freelancer.freelancer.model.response.base.WebResponse;
import com.freelancer.freelancer.model.response.user.LoginResponse;
import com.freelancer.freelancer.model.response.user.RegisterResponse;
import com.freelancer.freelancer.model.response.user.UserResponse;
import com.freelancer.freelancer.service.AuthenticateFacadeService;
import com.freelancer.freelancer.service.UserService;
import com.freelancer.freelancer.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticateFacade authenticateFacade;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/api/login")
    public WebResponse<String> login (@RequestBody LoginRequest loginRequest) throws NotAuthorizeException {

        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
            final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getEmail());
            final String token  = jwtUtil.generateToken(userDetails);

            return sendResponse(token);
        }catch (UsernameNotFoundException e){
            throw new NotAuthorizeException(e.getMessage());
        }catch (BadCredentialsException e){
            throw new NotAuthorizeException("Incorrect user or password");
        }
    }

    @PostMapping(value = "/api/register")
    public WebResponse<RegisterResponse> register (@RequestBody RegisterRequest registerRequest) throws Exception{
        RegisterResponse registerResponse = userService.register(registerRequest);
        return sendResponse(registerResponse);
    }

    @GetMapping(value = "/api/me")
    public WebResponse<UserResponse> me(){
        com.freelancer.freelancer.entity.User user = authenticateFacade.getAuthenticationUser();
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user,userResponse);
        return sendResponse(userResponse);
    }


}
