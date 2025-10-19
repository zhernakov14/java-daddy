package ru.andr.javadaddy.advanced.streams.topic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinStringsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("red", "green", "blue", "yellow"));

        System.out.println(list.stream().collect(Collectors.joining(", ")));
    }
}
