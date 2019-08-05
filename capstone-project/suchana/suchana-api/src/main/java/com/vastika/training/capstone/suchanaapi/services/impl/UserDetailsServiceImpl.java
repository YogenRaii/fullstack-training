package com.vastika.training.capstone.suchanaapi.services.impl;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.User;
import com.vastika.training.capstone.suchanaapi.repositories.UserRepository;
import com.vastika.training.capstone.suchanaapi.security.models.AuthenticatedUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.stream.Collectors;

@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsernameAndPassword()");
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new SuchanaApiException("Invalid Credentials!", 404);
        }

        return new AuthenticatedUser(user.getId(), username, user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole().name())));
    }
}
