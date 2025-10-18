package ru.andr.javadaddy.based;

import ru.andr.javadaddy.based.exception.ConversionException;
import ru.andr.javadaddy.based.converter.impl.LengthConverter;
import ru.andr.javadaddy.based.converter.impl.TemperatureConverter;
import ru.andr.javadaddy.based.converter.impl.WeightConverter;
import ru.andr.javadaddy.based.unit.LengthUnit;
import ru.andr.javadaddy.based.unit.TemperatureUnit;
import ru.andr.javadaddy.based.unit.WeightUnit;

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
                conversion(letters);
            } catch (ConversionException | RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void conversion(String[] letters) throws ConversionException {
        String category = letters[0].toLowerCase();
        double value = Double.parseDouble(letters[1]);
        String fromStr = letters[2];
        String toStr = letters[3];

        switch (category) {
            case "length": {
                LengthConverter converter = new LengthConverter();
                LengthUnit fromUnit = converter.parseUnit(fromStr);
                LengthUnit toUnit = converter.parseUnit(toStr);
                converter.convert(value, fromUnit, toUnit);
                break;
            }
            case "weight": {
                WeightConverter converter = new WeightConverter();
                WeightUnit fromUnit = converter.parseUnit(fromStr);
                WeightUnit toUnit = converter.parseUnit(toStr);
                converter.convert(value, fromUnit, toUnit);
                break;
            }
            case "temperature": {
                TemperatureConverter converter = new TemperatureConverter();
                TemperatureUnit fromUnit = converter.parseUnit(fromStr);
                TemperatureUnit toUnit = converter.parseUnit(toStr);
                converter.convert(value, fromUnit, toUnit);
                break;
            }
            default:
                throw new ConversionException("Unknown category: " + category);
        }
    }
}
