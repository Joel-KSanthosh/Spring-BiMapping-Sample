package com.study.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.sample.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

}
