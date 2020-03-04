package com.example.vnpost.controller;

import com.example.vnpost.model.ChuyenMuc;
import com.example.vnpost.model.DanhMuc;
import com.example.vnpost.model.Posts;
import com.example.vnpost.model.User;
import com.example.vnpost.service.ChuyenMucService;
import com.example.vnpost.service.DanhMucService;
import com.example.vnpost.service.PostService;
import com.example.vnpost.service.UserService;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class PostController {
    @Autowired
    private ChuyenMucService chuyenMucService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private DanhMucService danhMucService;

    @GetMapping("/posts")
    public ResponseEntity<Iterable<Posts>> listPosts(){
        Iterable<Posts> posts= postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    //them 1 bai viet trong danh muc
    @PostMapping("/danh-muc/{id}/posts")
    public ResponseEntity<Iterable<DanhMuc>> createPost(@PathVariable("id")Long id, @RequestBody Posts posts){
       Optional<DanhMuc> danhMuc1 = danhMucService.findById(id);
       if (danhMuc1.isPresent()){
          posts.setUserName(userService.getCurrentUser().getUsername());
          posts.setNameDanhMuc(danhMuc1.get().getNameDanhMuc());
          postService.save(posts);
          danhMuc1.get().getPostsList().add(posts);
          danhMucService.save(danhMuc1.get());
          return new ResponseEntity(posts,HttpStatus.CREATED);


       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    // chi tiet 1 bai viet trong danh muc
    @GetMapping("/post/{id}")
    public ResponseEntity<Posts> findById(@PathVariable Long id){
        Optional<Posts> posts = postService.findById(id);
        if (posts == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(posts,HttpStatus.OK);
    }

    //sua 1 bai viet
    @PutMapping("/posts/{id}")
    public ResponseEntity<Iterable<Posts>> edit (@PathVariable Long id,@RequestBody Posts posts){
        Optional<Posts> posts1 = postService.findById(id);
        if (posts1.isPresent()){
            posts1.get().setNameDanhMuc(posts.getNameDanhMuc());
            posts1.get().setContent(posts.getContent());
            posts1.get().setTitle(posts.getTitle());
            posts1.get().setImageUrls(posts.getImageUrls());
            postService.save(posts1.get());
            return new ResponseEntity(posts1,HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //xoa 1 bai viet
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Optional<Posts> posts=postService.findById(id);
        if (posts==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

