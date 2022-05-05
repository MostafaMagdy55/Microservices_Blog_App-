package com.microservices.users.Wrapper;


import com.microservices.users.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithPosts {
    private User user;
    private List<Post> posts;

}
