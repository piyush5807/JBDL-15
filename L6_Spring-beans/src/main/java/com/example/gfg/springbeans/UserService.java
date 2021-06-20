package com.example.gfg.springbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    public int parameter = 0;

    public UserService(@Value("${custom_prop}") int number){
        System.out.println("UserService object created = " + this + ",  number = " + number);
    }

    // UserService object created = com.example.gfg.springbeans.UserService@7c1e32c9
    // userService obj in UserController = com.example.gfg.springbeans.UserService@7c1e32c9

    public void createUser(User user){

    }


    /*
    2021-06-20 21:27:16.960 DEBUG 27907 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Creating shared instance of singleton bean 'userController'
UserService object created = com.example.gfg.springbeans.UserService@20134094
// com.example.gfg.springbeans.UserService@20134094
2021-06-20 21:27:16.967 DEBUG 27907 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Creating shared instance of singleton bean 'userController2'
UserService object created = com.example.gfg.springbeans.UserService@6b3f6585
com.example.gfg.springbeans.UserService@6b3f6585
2021

     */
}
