package com.vastika.training.capstone.suchanaapi.services.impl;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.User;
import com.vastika.training.capstone.suchanaapi.models.Category;
import com.vastika.training.capstone.suchanaapi.repositories.UserRepository;
import com.vastika.training.capstone.suchanaapi.repositories.CategoryRepository;
import com.vastika.training.capstone.suchanaapi.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public User update(User user) {
        boolean exists = this.userRepository.existsById(user.getId());
        if (!exists) {
            throw new SuchanaApiException("No User found with id: " + user.getId(), 404);
        }

        if (user.getCategories() == null) {
            user.setCategories(new HashSet<>());
        }

        if (user.getArticles() == null) {
            user.setArticles(new ArrayList<>());
        }

        return this.userRepository.save(user);
    }

    @Override
    public User createAuthor(User user) {
        user.setArticles(new ArrayList<>());

        // if no categories are supplied, then set empty categories
        if (user.getCategories() == null) {
            user.setCategories(new HashSet<>());
        } else {
            // need to make sure that category exists
            List<Category> existingCategories = this.categoryRepository.findAll();

            for (Category upcoming: user.getCategories()) {
                if (!existingCategories.contains(upcoming)) {
                    throw new SuchanaApiException("No category exists with id: " + upcoming.getId() + ", name: " + upcoming.getName(), 400);
                }
            }
        }

        User userInDb = this.userRepository.findByUsername(user.getUsername());

        if (userInDb != null) {
            throw new SuchanaApiException("User exists with username: " + user.getUsername(), 409);
        }

        User created = this.userRepository.save(user);

        log.info("User created with id : {}", created.getId());

        return created;
    }
}
