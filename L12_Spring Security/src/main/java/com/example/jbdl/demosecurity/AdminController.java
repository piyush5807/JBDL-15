package com.example.jbdl.demosecurity;

import lombok.Getter;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/view")
    public String view(){
        return "Welcome View!!";
    }

    @GetMapping("/admin")
    public Admin getAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Admin.builder()
                .name("DEF")
                .id(2)
                .age(40)
                .country("USA")
                .build();
    }

    @GetMapping("/welcome")
    public String greetUser(){
        return "Welcome!!";
    }
    
}
