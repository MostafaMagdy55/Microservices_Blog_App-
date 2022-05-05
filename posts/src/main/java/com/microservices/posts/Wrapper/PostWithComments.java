package com.microservices.posts.Wrapper;

import com.microservices.posts.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostWithComments {
    private Post post;
    private List<Comment> comment;
}
