package com.example.demojpa.user.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {
    
    @Email
    @NotEmpty
    private String email;
}
