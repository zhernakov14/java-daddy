package ru.andr.javadaddy.based.converter.impl;

import ru.andr.javadaddy.based.converter.BaseConverter;
import ru.andr.javadaddy.based.exception.ConversionException;
import ru.andr.javadaddy.based.unit.WeightUnit;

public class WeightConverter implements BaseConverter<WeightUnit> {

    private static final Double KILOGRAM_POUND = 0.45359;
    private static final Double KILOGRAM_OUNCE = 0.02835;

    @Override
    public void convert(Double value, WeightUnit fromUnit, WeightUnit toUnit) {
        
        double inKilogram = toKilogram(value, fromUnit);
        double result = fromKilogram(inKilogram, toUnit);

        System.out.printf("%.2f %s = %.2f %s%n", value, fromUnit, result, toUnit);
    }

    @Override
    public WeightUnit parseUnit(String unitStr) throws ConversionException {
        try {
            return WeightUnit.valueOf(unitStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ConversionException("Unknown unit: " + unitStr);
        }
    }

    private double toKilogram(double value, WeightUnit unit) {
        return switch (unit) {
            case POUND -> value * KILOGRAM_POUND;
            case OUNCE -> value * KILOGRAM_OUNCE;
            default -> value;
        };
    }

    private double fromKilogram(double kilogram, WeightUnit unit) {
        return switch (unit) {
            case POUND -> kilogram / KILOGRAM_POUND;
            case OUNCE -> kilogram / KILOGRAM_OUNCE;
            default -> kilogram;
        };
    }
}
