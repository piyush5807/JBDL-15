package com.example.gfg.libraryapp.services;

import com.example.gfg.libraryapp.models.*;
import com.example.gfg.libraryapp.repository.TransactionRepository;
import com.example.gfg.libraryapp.requests.IssueBookRequest;
import com.example.gfg.libraryapp.requests.ReturnBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    @Value("${students.max_allowed_books}")
    int maxAllowedBooks;


    @Value("${books.allotted_days}")
    int daysAllotted;

    @Value("${books.fine_per_day}")
    int finePerDay;


    @Transactional
    public String issueBook(IssueBookRequest issueBookRequest) throws Exception {

        int bookId = issueBookRequest.getBookId();
        int studentId = issueBookRequest.getStudentId();

        Book book = bookService.getBook(bookId);
        Student student = studentService.getStudent(studentId);

        if(book == null){
            throw new Exception("Book with id " + bookId + " could not be found in the library");
        }

        if(book.getStudent() != null){
            throw new Exception("Book with id " + bookId + " is already assigned to someone else");
        }

        if(student == null){
            throw new Exception("Student with id " + studentId + " is not present or account has been deleted");
        }

        if(student.getBooks().size() >= maxAllowedBooks){
            throw new Exception("Maximum no of books have already been assigned to the student " + studentId);
        }

        // 1. update the book table - studentid
        // 2. create a transaction

        Transaction transaction = Transaction.builder()
                .transactionStatus(TransactionStatus.PENDING)
                .book(book)
                .my_student(student)
                .transactionId(UUID.randomUUID().toString())
                .transactionType(TransactionType.ISSUE)
                .build();

        try{
            transaction = transactionRepository.save(transaction);
            book.setStudent(student);
            bookService.createOrUpdateBook(book); // update the existing book
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
//            transaction.setTransactTime(new Date()); // needed for @Transactional
            transactionRepository.save(transaction); // update the transaction entry
            return transaction.getTransactionId();
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setRemarks(e.getMessage());
            transactionRepository.save(transaction);
            throw new Exception("Transaction couldn't be completed - " + e.getMessage());
        }
    }

    public String returnBook(ReturnBookRequest returnBookRequest) throws Exception{

        int bookId = returnBookRequest.getBookId();
        int studentId = returnBookRequest.getStudentId();

        Transaction issueTransaction = transactionRepository.getTransaction(bookId, studentId);

        if(!TransactionType.ISSUE.equals(issueTransaction.getTransactionType())){
            throw new Exception("Issue transaction could not be found");
        }

        Book book = issueTransaction.getBook();
        Student student = issueTransaction.getMy_student();

        if(book == null){
            throw new Exception("Book with id " + bookId + " could not be found in the library");
        }

        if(book.getStudent() == null){
            throw new Exception("Book with id " + bookId + " is already assigned to someone else");
        }

        if(student == null){
            throw new Exception("Student with id " + studentId + " is not present or account has been deleted");
        }

        // Calculating the fine
        long issueTransactionMillis = issueTransaction.getTransactTime().getTime();
        long currentTimeMillis = System.currentTimeMillis();
        long timePassed = currentTimeMillis - issueTransactionMillis;
        long daysPassed = TimeUnit.DAYS.convert(timePassed, TimeUnit.MILLISECONDS);

        int fine = 0;

        if(daysPassed > daysAllotted){
            fine += (daysPassed - daysAllotted) * finePerDay;
        }

        Transaction transaction = Transaction.builder()
                .transactionType(TransactionType.RETURN)
                .book(book)
                .my_student(student)
                .transactionStatus(TransactionStatus.PENDING)
                .remarks(returnBookRequest.getRemarks())
                .transactionId(UUID.randomUUID().toString())
                .fine(fine)
                .build();

        transaction = transactionRepository.save(transaction);

        book.setStudent(null);

        bookService.createOrUpdateBook(book);


        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        transactionRepository.save(transaction);

        return transaction.getTransactionId();
    }
}
