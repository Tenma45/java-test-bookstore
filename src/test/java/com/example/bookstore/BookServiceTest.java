package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Test
    public void calculatePriceTest1(){
        List<Integer> order = new ArrayList<>(asList(1,1,1,1,1));
        BookService service = new BookService();
        int result = service.calculatePrice(order);
        assertEquals(375,result);
    }

    @Test
    public void calculatePriceTest2(){
        List<Integer> order = new ArrayList<>(asList(5));
        BookService service = new BookService();
        int result = service.calculatePrice(order);
        assertEquals(500,result);
    }

    @Test
    public void calculatePriceTest3(){
        List<Integer> order = new ArrayList<>(asList(5,4,3,2,1));
        BookService service = new BookService();
        int result = service.calculatePrice(order);
        assertEquals(1255,result);
    }
}