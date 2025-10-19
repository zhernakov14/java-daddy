package ru.andr.javadaddy.advanced.collections.topic2.task2;

public class Book implements Comparable<Book> {

    private final String title;
    private final Integer year;

    public Book(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.year, o.year);
    }

    @Override
    public String toString() {
        return title + " " + year;
    }
}
