package ru.andr.javadaddy.advanced.collections.topic2.task1;

import java.util.HashSet;
import java.util.Scanner;

public class DuplicateChecker {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (set.contains(line)) {
                System.out.println("Дубликат!");
                System.out.println(line);
            } else {
                set.add(line);
            }
        }
    }
}
