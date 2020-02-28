package com.example.vnpost.service.impl;

import com.example.vnpost.model.Posts;
import com.example.vnpost.repository.PostRepository;
import com.example.vnpost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Iterable<Posts> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Posts> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Posts posts) {
        postRepository.save(posts);

    }

    @Override
    public void delete(Long id) {
        Optional<Posts>posts = postRepository.findById(id);
            if (posts.isPresent()){
                postRepository.delete(posts.get());
            }

    }
}
