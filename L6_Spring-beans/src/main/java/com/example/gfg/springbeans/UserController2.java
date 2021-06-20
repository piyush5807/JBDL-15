package com.example.gfg.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController2 {

    @Autowired
    UserService userService;

    @Autowired
    ApplicationContext context;


    // userService obj = com.example.gfg.springbeans.UserService@2ab6964a
    // userService obj in UserController = com.example.gfg.springbeans.UserService@2ab6964a

    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name){
        System.out.println("userService obj = " + userService);
        return "Hello " + name + "!!!";
    }

    @GetMapping("/beans")
    public List<String> getBeans(){

        return Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList());

    }

}
