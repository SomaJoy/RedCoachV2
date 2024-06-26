package com.redCoach.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    private String token;
    private String tokenType = "Bearer";
}
