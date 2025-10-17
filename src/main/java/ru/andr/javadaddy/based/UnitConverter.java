package ru.andr.javadaddy.based;

import ru.andr.javadaddy.based.converter.BaseConverter;
import ru.andr.javadaddy.based.converter.exception.ConversionException;
import ru.andr.javadaddy.based.converter.impl.LengthConverter;
import ru.andr.javadaddy.based.converter.impl.TemperatureConverter;
import ru.andr.javadaddy.based.converter.impl.WeightConverter;

import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while(in.hasNextLine()) {

            String[] letters = in.nextLine().split(" ");
            if (letters.length != 4) {
                System.out.println("Wrong format");
                continue;
            }

            try {
                BaseConverter<?> converter = getImpl(letters[0]);
                converter.convert(Double.parseDouble(letters[1]), letters[2], letters[3]);
            } catch (ConversionException | RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static BaseConverter<?> getImpl(String letter) {
        return switch (letter) {
            case "length" -> new LengthConverter();
            case "temperature" -> new TemperatureConverter();
            case "weight" -> new WeightConverter();
            default -> throw new IllegalArgumentException("Unknown category: " + letter);
        };
    }
}
