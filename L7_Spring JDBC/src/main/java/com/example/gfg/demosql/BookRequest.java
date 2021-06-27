package com.example.gfg.demosql;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {

    private int cost;
    private String name;
    private String author;

}
