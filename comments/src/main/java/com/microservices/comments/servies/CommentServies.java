package com.microservices.comments.servies;


import com.microservices.comments.model.Comment;
import com.microservices.comments.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServies {

@Autowired
CommentRepository commentRepository;

    public void save( Comment user)
    {
        commentRepository.save(user);
    }
    public Comment findById(int id)
    {
        Optional<Comment> result=commentRepository.findById(id);
        Comment comment=null;
        if(result.isPresent())
        {
            comment=result.get();
        }
        else
            throw new RuntimeException("user not found"+ comment.getId());
        return comment;
    }

    public List<Comment> findAll()
    {
        return commentRepository.findAll();
    }
    public  void deleteById(int id)
    {
        Optional<Comment>result=commentRepository.findById(id);
        if(result.isPresent())
        {
            Comment comment=result.get();
            commentRepository.delete(comment);
        }
        else
        {
            throw  new RuntimeException("Cant delete because Usre not found ");
        }
    }
    ///////retrieve comments from post id////
    ///////it will use in RestTemplete//////
    public List<Comment> findCommentWithPostId(int id)
    {
        return commentRepository.findByPostid(id);
    }
}
