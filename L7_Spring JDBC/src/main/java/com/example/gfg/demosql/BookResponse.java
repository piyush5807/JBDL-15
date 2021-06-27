package com.example.gfg.demosql;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private List<Book> books;
    private long serverDate;
    private int status;

    public static BookResponse toBookResponse(List<Book> books){

        BookResponse bookResponse = BookResponse.builder()
                .books(books)
                .serverDate(System.currentTimeMillis())
                .status(books.size() == 0 ? 404 : 200)
                .build();

        return bookResponse;
    }
}
