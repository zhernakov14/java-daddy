package ru.andr.javadaddy.advanced.collections.topic2.task1;

import java.util.HashSet;

public class UniquePersons {
    public static void main(String[] args) {
        HashSet<Person> persons = new HashSet<>();

        persons.add(new Person("Andrey", 25));
        persons.add(new Person("Max", 14));
        persons.add(new Person("Katy", 55));
        persons.add(new Person("Andrey", 25));

        System.out.println(persons);
    }
}
