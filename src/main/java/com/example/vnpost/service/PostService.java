package com.example.vnpost.service;

import com.example.vnpost.model.Posts;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface PostService {
    Iterable<Posts> findAll();
    Optional<Posts> findById(Long id);
    void save(Posts posts);
    void delete(Long id);

}
