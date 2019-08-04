package com.vastika.training.capstone.suchanaapi.security.config;

import com.vastika.training.capstone.suchanaapi.security.JwtAuthenticationProvider;
import com.vastika.training.capstone.suchanaapi.security.JwtAuthenticationSuccessHandler;
import com.vastika.training.capstone.suchanaapi.security.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;


/**
 * Configuration for spring security implementation.
 *
 * @author Yogen
 */
@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final int ORDER = -100;

//    @Autowired
//    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private JwtAuthenticationProvider authenticationProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {

        return new ProviderManager(Arrays.asList(authenticationProvider));
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        JwtAuthenticationTokenFilter authenticationTokenFilter = new JwtAuthenticationTokenFilter();
        authenticationTokenFilter.setAuthenticationManager(authenticationManager());
        authenticationTokenFilter.setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());
        return authenticationTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf().disable()
                // permit swagger and signup for all
                .authorizeRequests().antMatchers("/user/**", "/articles/**")
                .permitAll().and()
                // All others urls must be authenticated (filter for token
                // always fires)
                .authorizeRequests().anyRequest().authenticated();
                // Call our errorHandler if authentication/authorisation fails
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
//                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint(SIGNUP_BASE_URL));
        // don't create session
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // Custom JWT based security filter
        httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);

        // disable page caching
        httpSecurity.headers().cacheControl();
    }
}
