package ru.andr.javadaddy.advanced.streams.topic2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonSortDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Alex", 22));
        people.add(new Person("Maria", 51));
        people.add(new Person("John", 11));
        people.add(new Person("Andrey", 7));
        people.add(new Person("Andrey", 11));
        people.add(new Person("Max", 42));

        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName))
                .toList();
        System.out.println(sortedPeople);
    }
}
