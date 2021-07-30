package com.example.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam("id") String id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) throws JsonProcessingException {
        userService.addUser(user);
    }
}
