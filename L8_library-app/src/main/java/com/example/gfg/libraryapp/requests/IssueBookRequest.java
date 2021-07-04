package com.example.gfg.libraryapp.requests;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IssueBookRequest {

    private int studentId;
    private int bookId;

}
