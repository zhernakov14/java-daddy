package ru.andr.javadaddy.advanced.streams.topic2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonToMapDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Alex", 22));
        people.add(new Person("Maria", 51));
        people.add(new Person("John", 11));
        people.add(new Person("Andrey", 7));
        people.add(new Person("Max", 42));

        Map<String, Integer> map = people.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println(map);
    }
}
