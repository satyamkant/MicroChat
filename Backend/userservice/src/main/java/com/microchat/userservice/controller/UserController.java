package com.microchat.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @PutMapping("/registration")
    ResponseEntity<String> registerUser(){

        return new ResponseEntity<>("Registered successfully!", HttpStatus.OK);
    }
}
