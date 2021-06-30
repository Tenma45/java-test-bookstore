package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public List<Book> getBook(){
        List<Book> books = repo.findAll();
        if(books != null) {
            return books;
        };throw new RuntimeException();
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public int buyBook(List<BookOrder> order) {

        List<Integer> totalBuy = new ArrayList<Integer>();

        for(BookOrder singleOrder: order){
            int volumeBuy = singleOrder.getVolume();
            int countBuy = singleOrder.getCount();
            Book bookInStore = repo.findById(volumeBuy).orElseThrow(RuntimeException::new);
            int countRemain = bookInStore.getCount();
            countRemain -= countBuy;
            if(countRemain >= 0){
                bookInStore.setCount(countRemain);
                repo.save(bookInStore);
                totalBuy.add(countBuy);
            }
            else throw new RuntimeException();
        }
        int totalPrice = calculatePrice(totalBuy);
        return totalPrice;
    }

    private int calculatePrice(List<Integer> totalBuy){
        int price = 0;
        return price;
    }
}
