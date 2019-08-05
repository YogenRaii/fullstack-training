package com.vastika.training.capstone.suchanaapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * employee
 * --------
 * id name    address_id
 * 1  yogen   1
 * 2  rai     2
 * <p>
 * address
 * -------
 * id   street
 * 1   3200 Parkwood
 * 2   Irving
 * <p>
 * <p>
 * <p>
 * <p>
 * user
 * --------
 * id firstName
 * 1    dheeraj
 * 2    saurav
 * <p>
 * <p>
 * category
 * ----------
 * id name
 * 1  Sport
 * 2  Politcs
 * <p>
 * <p>
 * author_category
 * --------------
 * author_id    category_id
 * 1              1
 * 1              2
 * 2              2
 */
@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "articles", "password"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
    @Size(min = 3, max = 40)
    private String password;

    private String role;

    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "user")
    private List<Article> articles;

    @Valid
    @NotNull
    @ManyToMany
    @JoinTable(
            name = "author_category",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Set<Category> categories;
}

