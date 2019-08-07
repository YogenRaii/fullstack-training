package com.vastika.training.capstone.suchanaapi.controllers;

import com.vastika.training.capstone.suchanaapi.models.dtos.LoginSuccessResponse;
import com.vastika.training.capstone.suchanaapi.security.models.AuthenticatedUser;
import com.vastika.training.capstone.suchanaapi.security.transfer.JwtUserDto;
import com.vastika.training.capstone.suchanaapi.security.utils.JwtTokenGenerator;
import com.vastika.training.capstone.suchanaapi.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthController {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Autowired
    private UserService userService;

    @PostMapping("/user/postLogin")
    public ResponseEntity<LoginSuccessResponse> pastLogin() {
        log.info("postLogin()");

        // read principal out of security context and set it to session
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication.getPrincipal() instanceof AuthenticatedUser)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }

        AuthenticatedUser authenticatedUser = (AuthenticatedUser) authentication.getPrincipal();
        String role = null;
        for (GrantedAuthority authority: authenticatedUser.getAuthorities()) {
            role = authority.getAuthority();
        }
        JwtUserDto dto = new JwtUserDto(authenticatedUser.getId(), authenticatedUser.getUsername(),role);
        String token = JwtTokenGenerator.generateToken(dto, jwtSecret);

        LoginSuccessResponse response = new LoginSuccessResponse(authenticatedUser.getId(), authenticatedUser.getUsername(), token, role);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
