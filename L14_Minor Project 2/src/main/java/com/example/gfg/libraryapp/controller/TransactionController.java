package com.example.gfg.libraryapp.controller;

import com.example.gfg.libraryapp.requests.IssueBookRequest;
import com.example.gfg.libraryapp.requests.ReturnBookRequest;
import com.example.gfg.libraryapp.security.User;
import com.example.gfg.libraryapp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction/issue")
    public String issueBook(@RequestParam("bookId") int bookId) throws Exception {

        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();

        IssueBookRequest issueBookRequest = IssueBookRequest.builder()
                .bookId(bookId)
                .studentId(user.getStudent().getId())
                .build();

        return transactionService.issueBook(issueBookRequest);
    }

    @PostMapping("/transaction/return")
    public String returnBook(@RequestParam("bookId") int bookId) throws Exception {

        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();

        ReturnBookRequest returnBookRequest = ReturnBookRequest.builder()
                .bookId(bookId)
                .studentId(user.getStudent().getId())
                .build();
        return transactionService.returnBook(returnBookRequest);
    }
}
