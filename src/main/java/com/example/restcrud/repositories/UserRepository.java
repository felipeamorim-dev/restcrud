package com.example.restcrud.repositories;

import com.example.restcrud.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
