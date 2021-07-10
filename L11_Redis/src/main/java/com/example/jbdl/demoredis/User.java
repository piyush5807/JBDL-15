package com.example.jbdl.demoredis;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private String country;
    private Address address;
}
