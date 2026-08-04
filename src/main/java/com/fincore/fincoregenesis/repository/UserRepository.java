package com.fincore.fincoregenesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fincore.fincoregenesis.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
