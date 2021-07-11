package com.example.jbdl.demosecurity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Admin {

    private int id;
    private String name;
    private int age;
    private String country;
}
