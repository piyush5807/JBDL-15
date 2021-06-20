package com.example.gfg.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component // controller -> component
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    User user;

//    UserController(UserService userService){
//        this.userService = userService;
//        System.out.println("parameter = " + this.userService.parameter);
//    }

    @RequestMapping("/user")
    public void createUser(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("age") int age){

        user.setAge(age);
        user.setId(id);
        user.setName(name);

    }

    @GetMapping("/users")
    public List<User> getUsers(){

        return Arrays.asList(user);

//        System.out.println("userService obj in UserController = " + this.userService);
//
//        UserService userService = new UserService();
//        System.out.println("userService obj in UserController = " + userService);
//        return new ArrayList<>();
    }
}
