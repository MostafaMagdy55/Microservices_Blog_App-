package com.microservices.comments.controller;

import com.microservices.comments.model.Comment;
import com.microservices.comments.servies.CommentServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api3")
public class CommentController {



    @Autowired
    CommentServies commentServies;

    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        commentServies.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(comment);
    }

    @PutMapping ("/comment}")
    public ResponseEntity<Comment> update(@RequestBody Comment comment) {
        commentServies.save(comment);
        return ResponseEntity.status(HttpStatus.OK.value()).body(comment);
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> findComment(@PathVariable int id) {
        Comment comment = commentServies.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(comment);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> findAllComments() {
        List<Comment> users = commentServies.findAll();
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(users);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> delete(@PathVariable int id) {
        commentServies.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

////////this will call from post controller by RestTemplete
    @GetMapping("/comments/post/{id}")
    public ResponseEntity<List<Comment>> findCommentsByPostId(@PathVariable int id) {
        List<Comment> comments = commentServies.findCommentWithPostId(id);
        return ResponseEntity.status(HttpStatus.FOUND.value()).body(comments);
    }

}
