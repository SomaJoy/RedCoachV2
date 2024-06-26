package com.redCoach.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private int id;
    private String userName;
    private String email;
    private String password;
    private String role;
}
