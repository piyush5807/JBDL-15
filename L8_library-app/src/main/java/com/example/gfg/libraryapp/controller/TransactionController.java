package com.example.gfg.libraryapp.controller;

import com.example.gfg.libraryapp.requests.IssueBookRequest;
import com.example.gfg.libraryapp.requests.ReturnBookRequest;
import com.example.gfg.libraryapp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public String issueBook(@RequestBody IssueBookRequest issueBookRequest) throws Exception {
        return transactionService.issueBook(issueBookRequest);
    }

    @PostMapping("/return")
    public String returnBook(@RequestBody ReturnBookRequest returnBookRequest) throws Exception {
        return transactionService.returnBook(returnBookRequest);
    }
}
