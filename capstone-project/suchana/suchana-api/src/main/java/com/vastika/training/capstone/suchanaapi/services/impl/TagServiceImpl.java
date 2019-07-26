package com.vastika.training.capstone.suchanaapi.services.impl;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.models.Tag;
import com.vastika.training.capstone.suchanaapi.repositories.TagRepository;
import com.vastika.training.capstone.suchanaapi.services.TagService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return this.tagRepository.findAll();
    }

    @Override
    public Tag findById(int id) {
        return this.tagRepository.getOne(id);
    }

    @Override
    public Tag createTag(Tag tag) {
        return this.tagRepository.save(tag);
    }

    @Override
    public void deleteTag(int id) {
        boolean exists = this.tagRepository.existsById(id);
        if (!exists) {
            throw new SuchanaApiException("No Tag found with id: " + id, 404);
        }
        this.tagRepository.deleteById(id);
    }

    @Override
    public Tag updateTag(Tag tag) {
        log.info("updateTag() -> {}", tag.getId());

        boolean exists = this.tagRepository.existsById(tag.getId());
        if (!exists) {
            throw new SuchanaApiException("No Tag found with id : " + tag.getId(), 404);
        }
        Tag updated = this.tagRepository.save(tag);

        log.info("updateTag() -> Update success!");

        return updated;
    }
}
