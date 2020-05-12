package com.example.demo.rest;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth/")
public class AuthenticationRestController {

    private UserRepository userRepository;

    public AuthenticationRestController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/role/{username}")
    public Role getUserRole(@PathVariable("username") String username){

        Optional<User> userOptional=userRepository.findByUserName(username);
        if(userOptional.isPresent()){
            User user=userOptional.get();
            return user.getUserRole();
        }

        return null;
    }

}
