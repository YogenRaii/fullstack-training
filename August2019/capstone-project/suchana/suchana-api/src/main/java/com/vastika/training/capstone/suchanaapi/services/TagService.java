package com.vastika.training.capstone.suchanaapi.services;

import com.vastika.training.capstone.suchanaapi.models.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();
    Tag findById(int id);
    Tag createTag(Tag tag);
    void deleteTag(int id);
    Tag updateTag(Tag tag);
}
