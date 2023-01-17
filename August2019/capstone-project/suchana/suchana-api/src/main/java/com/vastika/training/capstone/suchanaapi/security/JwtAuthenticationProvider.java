package com.vastika.training.capstone.suchanaapi.security;


import com.vastika.training.capstone.suchanaapi.models.User;
import com.vastika.training.capstone.suchanaapi.repositories.UserRepository;
import com.vastika.training.capstone.suchanaapi.security.exceptions.JwtTokenExpiredException;
import com.vastika.training.capstone.suchanaapi.security.exceptions.JwtTokenMalformedException;
import com.vastika.training.capstone.suchanaapi.security.exceptions.JwtUserNotFoundException;
import com.vastika.training.capstone.suchanaapi.security.models.AuthenticatedUser;
import com.vastika.training.capstone.suchanaapi.security.models.JwtAuthenticationToken;
import com.vastika.training.capstone.suchanaapi.security.transfer.JwtUserDto;
import com.vastika.training.capstone.suchanaapi.security.utils.JwtTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author Yogen
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtTokenValidator jwtTokenValidator;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        //no need implementation as no additional authentication is required
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = jwtAuthenticationToken.getToken();

        JwtUserDto parsedUser = jwtTokenValidator.parseToken(token);

        if (parsedUser == null) {
            throw new JwtTokenMalformedException("JWT token is not valid");
        }

        //validate against stored user
        User user = this.userRepository.findByUsername(parsedUser.getUsername());

        if (user != null) {
            if (!parsedUser.getUsername().equals(user.getUsername())) {
                throw new JwtTokenExpiredException("JWT Token expired.");
            }
        } else {
            throw new JwtUserNotFoundException("User with JWT token not found");
        }

        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRole());

        return new AuthenticatedUser(parsedUser.getId(), parsedUser.getUsername(), token, authorityList);
    }


}
