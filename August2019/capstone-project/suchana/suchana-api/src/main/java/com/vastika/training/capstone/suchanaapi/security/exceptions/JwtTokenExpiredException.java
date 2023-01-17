/**
 *
 */
package com.vastika.training.capstone.suchanaapi.security.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Yogen
 */
public class JwtTokenExpiredException extends AuthenticationException {

    /**
     * @param msg
     */
    public JwtTokenExpiredException(String msg) {
        super(msg);
    }

}
