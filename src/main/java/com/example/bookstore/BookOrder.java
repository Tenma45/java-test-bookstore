package com.example.bookstore;

public class BookOrder {
    private int volume;
    private int count;

    public BookOrder() {
    }

    public BookOrder(int volume, int count) {
        this.volume = volume;
        this.count = count;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
