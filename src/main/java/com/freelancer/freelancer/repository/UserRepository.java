package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    Boolean existsUserByEmail(String email);
    User findUserByEmail(String email);
}
