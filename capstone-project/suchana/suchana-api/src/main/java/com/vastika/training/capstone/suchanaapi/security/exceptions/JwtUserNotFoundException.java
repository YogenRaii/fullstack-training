/**
 *
 */
package com.vastika.training.capstone.suchanaapi.security.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Yogen
 */
public class JwtUserNotFoundException extends AuthenticationException {

    /**
     * @param msg
     */
    public JwtUserNotFoundException(String msg) {
        super(msg);
    }

}
