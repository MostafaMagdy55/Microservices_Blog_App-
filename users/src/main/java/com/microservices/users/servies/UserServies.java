package com.microservices.users.servies;


import com.microservices.users.Wrapper.Post;
import com.microservices.users.Wrapper.UserWithPosts;
import com.microservices.users.model.User;


import com.microservices.users.repository.UsreRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServies {
    @Autowired
    UsreRepository usreRepository;
    @Autowired
    RestTemplate restTemplate;


    public void save(User user) {
        usreRepository.save(user);
    }

    public User findById(int id) {
        Optional<User> result = usreRepository.findById(id);
        User user = null;
        if (result.isPresent()) {
            user = result.get();
        } else
            throw new RuntimeException("user not found" + user.getId());
        return user;
    }

    public List<User> findAll() {
        return usreRepository.findAll();
    }

    public void deleteById(int id) {
        Optional<User> result = usreRepository.findById(id);
        if (result.isPresent()) {
            User user = result.get();
            usreRepository.delete(user);
        } else {
            throw new RuntimeException("Cant delete because Usre not found ");
        }

    }



    public UserWithPosts findByUserWithPosts(int id) {
        Optional<User> result = usreRepository.findById(id);

        User user = null;
        if (result.isPresent()) {
            user = result.get();
        } else
            throw new RuntimeException("post not found" + user.getId());
        UserWithPosts userWithPosts = new UserWithPosts();
        userWithPosts.setUser(user);
        ResponseEntity<Post[]> response = restTemplate.getForEntity("http://POSTS/api2/posts/user/" + id, Post[].class);
        List<Post> posts = Arrays.asList(response.getBody());
        userWithPosts.setPosts(posts);
        return userWithPosts;
    }
}
