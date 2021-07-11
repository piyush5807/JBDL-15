package com.example.jbdl.demosecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Student.builder().age(10).id(1).name("ABC").country("India").build();
    }


}
