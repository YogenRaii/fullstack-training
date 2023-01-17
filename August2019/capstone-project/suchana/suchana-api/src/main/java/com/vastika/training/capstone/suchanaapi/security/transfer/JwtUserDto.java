package com.vastika.training.capstone.suchanaapi.security.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Holds info extracted from JWT
 *
 * @author Yogen
 */
@Getter
@AllArgsConstructor
@ToString
public class JwtUserDto {
    private int id;

    private String username;

    private String role;

}
