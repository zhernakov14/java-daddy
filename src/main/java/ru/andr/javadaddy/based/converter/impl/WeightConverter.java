package ru.andr.javadaddy.based.converter.impl;

import ru.andr.javadaddy.based.converter.BaseConverter;
import ru.andr.javadaddy.based.converter.exception.ConversionException;
import ru.andr.javadaddy.based.converter.util.ConverterUtil;
import ru.andr.javadaddy.based.unit.WeightUnit;

public class WeightConverter extends ConverterUtil implements BaseConverter<WeightUnit> {

    private static final Double KILOGRAM_POUND = 0.45359;
    private static final Double KILOGRAM_OUNCE = 0.02835;

    @Override
    public void convert(Double value, String fromUnit, String toUnit) throws ConversionException {
        
        WeightUnit fromUnitEnum = parseUnit(WeightUnit.class, fromUnit);
        WeightUnit toUnitEnum = parseUnit(WeightUnit.class, toUnit);

        double inKilogram = toKilogram(value, fromUnitEnum);
        double result = fromKilogram(inKilogram, toUnitEnum);

        System.out.printf("%.2f %s = %.2f %s%n", value, fromUnit, result, toUnit);
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
