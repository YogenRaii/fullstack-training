package com.vastika.training.capstone.suchanaapi.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginSuccessResponse {
    private int id;
    private String username;
    private String token;
    private String role;
}
