package com.soloworld.blog.controller;

import com.soloworld.blog.dto.PostInput;
import com.soloworld.blog.dto.PostResponse;
import com.soloworld.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping("/post")
    public ResponseEntity<List<PostResponse>> getPost() {
      return   new ResponseEntity<>(blogService.getAllPost() , HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostInput postInput) {
      return   new ResponseEntity<>(blogService.createPost(postInput) , HttpStatus.CREATED);
    }
    @PutMapping ("/post/{postId}")
    public ResponseEntity<PostResponse> updatePost(@RequestBody PostInput postInput, @PathVariable Long postId) {
      return   new ResponseEntity<>(blogService.updatePost(postId,postInput) , HttpStatus.ACCEPTED);
    }

    @DeleteMapping ("/post/{postId}")
    public ResponseEntity<Boolean> deletePost( @PathVariable Long postId) {
      return   new ResponseEntity<>(blogService.deletePost(postId) , HttpStatus.ACCEPTED);
    }
}
