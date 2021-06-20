package com.example.gfg.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class User {

    private int id;
    private String name;
    private int age;
}
