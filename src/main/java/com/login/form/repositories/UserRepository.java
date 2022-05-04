package com.login.form.repositories;

import java.util.Optional;

import com.login.form.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findUserByUsername(String username);

}
