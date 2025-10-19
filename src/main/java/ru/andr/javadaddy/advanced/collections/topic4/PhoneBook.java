package ru.andr.javadaddy.advanced.collections.topic4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Alex", "333");
        map.put("Max", "774");
        map.put("John", "913");
        map.put("Katy", "193");
        map.put("Maria", "351");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            if (map.containsKey(name)) {
                System.out.println(map.get(name));
            } else {
                System.out.println("Такого имени в справочнике нет");
            }
        }
    }
}
