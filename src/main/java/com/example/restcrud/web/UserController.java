package com.example.restcrud.web;

import com.example.restcrud.repositories.UserRepository;
import com.example.restcrud.repositories.UserRoleRepository;
import com.example.restcrud.user.User;
import com.example.restcrud.user.UserCreateRequest;
import com.example.restcrud.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRoleRepository userRoleRepository, UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
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

    @PostMapping({"", "/"})
    @ResponseBody
    public User createUser(@RequestBody @Valid UserCreateRequest request){
        UserRole role = userRoleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new IllegalArgumentException());

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(role);
        user.setCreatedAt(new Date());

        return userRepository.save(user);
    }
}
