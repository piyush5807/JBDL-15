package com.example.gfg.libraryapp.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRequest {

    private String email;
    private int age;
    private String name;
}
