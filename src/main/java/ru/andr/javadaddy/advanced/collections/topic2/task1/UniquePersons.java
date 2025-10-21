package ru.andr.javadaddy.advanced.collections.topic2.task1;

import java.util.HashSet;
import java.util.Set;

public class UniquePersons {
    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();

        persons.add(new Person("Andrey", 25));
        persons.add(new Person("Max", 14));
        persons.add(new Person("Katy", 55));
        persons.add(new Person("Andrey", 25));

        System.out.println(persons);
    }
}
