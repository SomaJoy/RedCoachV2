package com.redCoach.service;

import com.redCoach.entity.User;

public interface JwtService {

    public String generateToken(User user);
    public String getUserName(String token);
}
