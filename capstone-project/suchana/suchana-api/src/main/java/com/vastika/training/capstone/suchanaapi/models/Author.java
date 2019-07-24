package com.vastika.training.capstone.suchanaapi.models;

import lombok.*;

import javax.persistence.*;
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
 * author
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
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @OneToMany
    private List<Article> articles;

    @OneToMany
    @JoinTable(
            name = "author_category",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
}

