package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public void setRepo(BookRepository repo){
        this.repo = repo;
    }

    public List<Book> getBook(){
        List<Book> books = repo.findAll();
        if(books != null) {
            return books;
        };throw new RuntimeException();
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public List<Book> addBooks(List<Book> books){
        for(Book book: books){
            repo.save(book);
        }
        return books;
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

    public int calculatePrice(List<Integer> totalBuy){
        int price = 0;
        List<Integer> grouped = new ArrayList<>();
        List<Integer> tempTotalBuy = totalBuy; //todo (we need all possible cases)
        int groupingSize = totalBuy.size();
        //start with largest group as possible then reduce
        while(groupingSize>1){
            // minus each volume by 1 until reach grouping count
                for(int volume=0;volume<groupingSize;volume++){
                    totalBuy.set(volume, totalBuy.get(volume) - 1);
                };
                // when volume reach 0, remove from totalBuy
                for(int volume=0;volume<totalBuy.size();volume++) {
                    if (totalBuy.get(volume) <= 0) {
                        totalBuy.remove(volume);
                        volume-=1;
                    }
                };
                // record when grouping has finished
                grouped.add(groupingSize);
                // new groupSize is equal to current totalBut Size
                groupingSize = totalBuy.size();
        }
        //now totalBuy remain only a volume, append count of this volume as 1
        if(totalBuy.size()>0){
            for(int i=0;i<totalBuy.get(0);i++){grouped.add(1);}
        }

        System.out.println("Grouped: "+grouped);
        for(Integer group: grouped){
            price += group == 5? (5 * 0.75 * 100)
                    :group == 4? (4 * 0.8 * 100)
                    :group == 3? (3 * 0.9 * 100)
                    :group == 2? (2 * 0.95 * 100)
                    :(1 * 100);
        }
        return price;
    }
}
