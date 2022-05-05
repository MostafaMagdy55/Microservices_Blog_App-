package com.microservices.posts.controller;

import com.microservices.posts.Wrapper.PostWithComments;
import com.microservices.posts.model.Post;
import com.microservices.posts.servies.PostServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class PostController {


    @Autowired
    PostServies postServies;

    @PostMapping("/post")
    public ResponseEntity<Post> createComment(@RequestBody Post post) {
        postServies.save(post);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(post);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> findComment(@PathVariable int id) {
        Post post = postServies.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(post);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAllComments() {
        List<Post> posts = postServies.findAll();
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> delete(@PathVariable int id) {
        postServies.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/post/{id}/comments")
    public ResponseEntity<PostWithComments> PostWithComment(@PathVariable int id) {
        PostWithComments postWithComments = postServies.findByPostWithComments(id);
        return new ResponseEntity<>(postWithComments, HttpStatus.OK);
    }


////////this will call from user service to retrieve posts
    @GetMapping("/posts/user/{id}")
    public ResponseEntity<List<Post>> findCommentsByPostId(@PathVariable int id) {
        List<Post> posts = postServies.findPosttWithUserid(id);
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(posts);
    }
}
