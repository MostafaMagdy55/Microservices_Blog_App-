package com.microservices.posts.servies;

import com.microservices.posts.Wrapper.Comment;
import com.microservices.posts.Wrapper.PostWithComments;
import com.microservices.posts.model.Post;
import com.microservices.posts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PostServies {
    @Autowired
    PostRepository postRepository;
    @Autowired
    RestTemplate restTemplate;

    public void save(Post post) {
        postRepository.save(post);
    }

    public Post findById(int id) {
        Optional<Post> result = postRepository.findById(id);
        Post post = null;
        if (result.isPresent()) {
            post = result.get();
        } else
            throw new RuntimeException("post not found" + post.getId());
        return post;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void deleteById(int id) {
        Optional<Post> result = postRepository.findById(id);
        if (result.isPresent()) {
            Post comment = result.get();
            postRepository.delete(comment);
        } else {
            throw new RuntimeException("Cant delete because Post not found ");
        }


    }


    /////to retreive comments from post id
    public PostWithComments findByPostWithComments(int id) {
        Optional<Post> result = postRepository.findById(id);

        Post post = null;
        if (result.isPresent()) {
            post = result.get();
        } else
            throw new RuntimeException("post not found" + post.getId());
        PostWithComments postWithComments = new PostWithComments();
        postWithComments.setPost(post);
        ResponseEntity<Comment[]> response = restTemplate.getForEntity("http://COMMENTS/api3/comments/post/" + id, Comment[].class);
        List<Comment> comments = Arrays.asList(response.getBody());
        postWithComments.setComment(comments);
        return postWithComments;
    }

////////this to retrieve posts from userId
    public List<Post> findPosttWithUserid(int id)
    {
        return postRepository.findByUserid(id);
    }
}
