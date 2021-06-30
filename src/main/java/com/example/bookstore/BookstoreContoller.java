package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
public class BookstoreContoller {

    @Autowired
    private BookService service;

    @GetMapping("/book")
    public List<Book> getAllBook(){
        return service.getBook();
    }

    @PostMapping("/books")
        public List<Book> addBooks(@RequestBody List<Book> books){
            return service.addBooks(books);
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return service.addBook(book);
    }


    @PutMapping("/book")
    public int buyBook(@RequestBody List<BookOrder> order){
        return service.buyBook(order);
    }

}
