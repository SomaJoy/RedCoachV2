package com.redCoach.controller;

import com.redCoach.entity.User;
import com.redCoach.payload.JwtResponse;
import com.redCoach.payload.LoginDto;
import com.redCoach.payload.UserDto;
import com.redCoach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        User user = userService.addUser(userDto);
        if (user != null)
           return new ResponseEntity<>("Registration sucessful.", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Registration failed.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        String jwtToken =userService.verifyLogin(loginDto);
        if (jwtToken != null){
            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.setToken(jwtToken);
            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid username or password.", HttpStatus.UNAUTHORIZED);
    }
}
