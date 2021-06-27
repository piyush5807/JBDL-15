package com.example.gfg.demosql;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int id;
    private String name;
    private String authorName;
    private int cost;


}
