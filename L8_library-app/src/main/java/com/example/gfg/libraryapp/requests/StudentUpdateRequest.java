package com.example.gfg.libraryapp.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentUpdateRequest {

    private String name;
    private String email;
    private int age;
}
