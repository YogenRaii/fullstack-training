package com.vastika.training.capstone.suchanaapi.security;


import com.vastika.training.capstone.suchanaapi.security.exceptions.JwtTokenMissingException;
import com.vastika.training.capstone.suchanaapi.security.models.JwtAuthenticationToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yogen
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
    private static final int HEADER_LENGTH = 7;

    private static final List<RequestMatcher> PATHS = Arrays.asList(
            new AntPathRequestMatcher("/categories/**"),
            new AntPathRequestMatcher("/tags/**"),
            new AntPathRequestMatcher("/authors/**")
    );

    public JwtAuthenticationTokenFilter() {
        super(new OrRequestMatcher(PATHS));
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        String header = request.getHeader("Authorization");

        String authToken;

        if (header != null && header.startsWith("Bearer ")) {
            authToken = header.substring(HEADER_LENGTH);
        } else {
            throw new JwtTokenMissingException("No JWT token found in request headers");
        }

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);

    }

    /**
     * Make sure the rest of the filterchain is satisfied
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        log.info("Authenticated User: {}", authResult.getPrincipal());
        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        chain.doFilter(request, response);
    }
}
