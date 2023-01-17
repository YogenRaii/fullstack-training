package com.vastika.training.capstone.suchanaapi.models.dtos;

import com.vastika.training.capstone.suchanaapi.models.Category;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * CQRS pattern
 * Create Query responsibility pattern
 */
@Data
public class CreateUserRequest {
    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "[a-zA-Z]+")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "[a-zA-Z]+")
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[a-zA-Z0-9]+") // restricts yogen.rai but allows yogenrai19
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(min = 3, max = 500)
    private String password;

    @Valid
    @NotNull
    private Set<Category> categories;
}

