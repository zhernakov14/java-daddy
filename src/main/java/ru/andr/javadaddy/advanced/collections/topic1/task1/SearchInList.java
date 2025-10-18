package ru.andr.javadaddy.advanced.collections.topic1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchInList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Ann");
        list.add("Katy");
        list.add("Max");
        list.add("Andrey");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if (list.contains(name)) {
            System.out.println("Найдено");
        } else {
            System.out.println("Не найдено");
        }
    }
}
