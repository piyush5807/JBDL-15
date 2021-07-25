package com.example.gfg.libraryapp.requests;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBookRequest {

    private int studentId;
    private int bookId;
    private String remarks;

}
