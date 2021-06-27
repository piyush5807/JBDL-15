package com.example.gfg.demosql;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component  // DB operations
public class BookRepository {

    private static Connection connection;

    public BookRepository() throws SQLException {

        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl15", "root", "");
        }

        createTable();
    }

    private void createTable() throws SQLException {

        Statement statement = connection.createStatement();
        boolean response = statement.execute("create table if not exists book(id int auto_increment primary key, " +
                "name VARCHAR(30), authorName VARCHAR(30), cost int)");

        System.out.println("response - " + response);
    }


    public void createBook(BookRequest book) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(
                "insert into book(name, authorName, cost) VALUES(?, ?, ?)"
        );

        statement.setString(1, book.getName());
        statement.setString(2, book.getAuthor());
        statement.setInt(3, book.getCost());

        int rowsAdded = statement.executeUpdate();

        System.out.println("No of books added - " + rowsAdded);
    }

    public List<Book> getBooks() throws SQLException {

        PreparedStatement statement = connection.prepareStatement("select * from book");
        ResultSet resultSet = statement.executeQuery();

        List<Book> bookList = new ArrayList<>();

        while(resultSet.next()){

            Book book = Book.builder()
                    .name(resultSet.getString(2))
                    .id(resultSet.getInt("id"))
                    .cost(resultSet.getInt(4))
                    .authorName(resultSet.getString(3))
                    .build();

            bookList.add(book);
        }

        return bookList;
    }

    public Book getBookById(int id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("select * from book where id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Book bookToReturn = null;
        while(resultSet.next()){

            Book book = Book.builder()
                    .name(resultSet.getString(2))
                    .id(resultSet.getInt("id"))
                    .cost(resultSet.getInt(4))
                    .authorName(resultSet.getString(3))
                    .build();

            bookToReturn = book;
        }

        return bookToReturn;

    }

}
