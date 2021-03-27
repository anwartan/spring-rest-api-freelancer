package com.freelancer.freelancer.entity;

import com.freelancer.freelancer.model.response.user.LoginResponse;
import com.freelancer.freelancer.model.response.user.RegisterResponse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Id
    @GenericGenerator(
            name = "user-id-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "user-id-sequence-generator")
    private Integer id;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column( name ="emailVerificationToken")
    private String emailVerificationToken;

    @Column(nullable = false,name ="emailVerificationStatus")
    private Boolean emailVerificationStatus = false;

    @Column(name = "token")
    private String token;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "since")
    private Year since;

    @Column(name = "description")
    private String description;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "google")
    private String google;

    @Column(name = "github")
    private String github;

    @OneToMany(mappedBy = "user")
    private Set<List> lists = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Year getSince() {
        return since;
    }

    public void setSince(Year since) {
        this.since = since;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public LoginResponse toLoginResponse(){

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(this.id);
        loginResponse.setEmail(this.email);
        loginResponse.setName(this.name);
        loginResponse.setToken(this.token);
        return loginResponse;
    }
    public RegisterResponse toRegisterResponse(){

        com.freelancer.freelancer.model.response.user.RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setId(this.id);
        registerResponse.setEmail(this.email);
        registerResponse.setName(this.name);
        registerResponse.setToken(this.token);
        return registerResponse;
    }
}
