package com.example.vnpost.controller;

import com.example.vnpost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PostController {
    @Autowired
    private PostService postService;
}
