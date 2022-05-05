package com.microservices.posts.Wrapper;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private int id;
    private String Content;
    private int postid;

}
