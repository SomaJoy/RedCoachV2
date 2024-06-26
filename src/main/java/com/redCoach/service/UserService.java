package com.redCoach.service;

import com.redCoach.entity.User;
import com.redCoach.payload.LoginDto;
import com.redCoach.payload.UserDto;

public interface UserService {

    public User addUser(UserDto userDto);

    String verifyLogin(LoginDto loginDto);
}
