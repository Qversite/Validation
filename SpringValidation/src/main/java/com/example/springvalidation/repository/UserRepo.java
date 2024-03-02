package com.example.springvalidation.repository;

import com.example.springvalidation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
