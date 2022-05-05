package com.microservices.comments;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testCon {

    @Value("${mostafa.m}")
    String val;
    @RequestMapping("/me")
    public  String testme()
    {
        return val;
    }

}
