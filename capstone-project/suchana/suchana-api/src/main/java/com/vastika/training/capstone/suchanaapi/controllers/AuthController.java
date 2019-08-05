package com.vastika.training.capstone.suchanaapi.controllers;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaDataException;
import com.vastika.training.capstone.suchanaapi.models.User;
import com.vastika.training.capstone.suchanaapi.models.dtos.LoginRequest;
import com.vastika.training.capstone.suchanaapi.models.dtos.LoginSuccessResponse;
import com.vastika.training.capstone.suchanaapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public ResponseEntity<LoginSuccessResponse> login(@Valid @RequestBody LoginRequest request, BindingResult result) {
        if (result.hasErrors()) {
            throw new SuchanaDataException("Invalid Payload!", result.getFieldErrors());
        }
        User user = this.userService.loadUserByUsernameAndPassword(request.getUsername(), request.getPassword());
        LoginSuccessResponse response = new LoginSuccessResponse(user.getId(), user.getUsername(), user.getRole());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
