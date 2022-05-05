package com.microservices.posts.repository;

import com.microservices.posts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post>findByUserid(int UsreId);
}
