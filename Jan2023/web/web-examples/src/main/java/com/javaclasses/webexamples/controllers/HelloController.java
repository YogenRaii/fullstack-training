package com.javaclasses.webexamples.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping("/")
    public String hello() {
        return "{\"message\":\"hello\"}";
    }
}
