package ru.andr.javadaddy.advanced.streams.topic1;

import java.util.Arrays;

public class ConverterDemo {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};

        Converter converter = n -> n * n;
        System.out.println(Arrays.toString(convertArray(array, converter)));
    }

    private static int[] convertArray(int[] array, Converter converter) {
        for (int i = 0; i < array.length; i++) {
            array[i] = converter.convert(array[i]);
        }
        return array;
    }
}
