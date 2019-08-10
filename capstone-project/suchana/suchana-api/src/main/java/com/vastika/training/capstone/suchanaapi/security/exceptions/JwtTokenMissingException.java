/**
 *
 */
package com.vastika.training.capstone.suchanaapi.security.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Yogen
 */
public class JwtTokenMissingException extends AuthenticationException {

    /**
     * @param msg
     */
    public JwtTokenMissingException(String msg) {
        super(msg);
    }

}
