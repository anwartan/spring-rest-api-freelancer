package com.freelancer.freelancer.model.response.user;

public class LoginResponse {
    private Integer id;

    private String email;

    private String name;

    private String token;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
