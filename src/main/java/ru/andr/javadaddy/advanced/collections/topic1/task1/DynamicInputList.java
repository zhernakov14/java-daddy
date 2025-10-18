package ru.andr.javadaddy.advanced.collections.topic1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicInputList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int counter = 0;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("стоп")) {
                break;
            }
            list.add(input);
            counter++;
        }
        System.out.println(counter + " " + list);
    }
}
