package com.educandoweb.course.controller;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResourceController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity <List<User>> findAll(){
        List<User> list = userService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = userService.findById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User obj){
        User user = userService.insert(obj);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
