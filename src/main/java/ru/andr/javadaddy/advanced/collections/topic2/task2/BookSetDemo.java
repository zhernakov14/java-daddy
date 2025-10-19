package ru.andr.javadaddy.advanced.collections.topic2.task2;

import java.util.Set;
import java.util.TreeSet;

public class BookSetDemo {
    public static void main(String[] args) {
        Set<Book> books = new TreeSet<>();

        books.add(new Book("ASD", 1999));
        books.add(new Book("SDF", 2005));
        books.add(new Book("GFH", 1894));
        books.add(new Book("CVB", 1703));

        System.out.println(books);
    }
}
