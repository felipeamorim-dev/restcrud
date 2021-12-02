package com.example.restcrud.web;

import com.example.restcrud.repositories.UserRoleRepository;
import com.example.restcrud.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserController(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping("/roles")
    @ResponseBody
    public Page<UserRole> getRoles(Pageable pageable){
        return userRoleRepository.findAll(pageable);
    }

    @GetMapping("/role/{id}")
    @ResponseBody
    public Optional<UserRole> getRole(@PathVariable Long id){
        return userRoleRepository.findById(id);
    }
}
