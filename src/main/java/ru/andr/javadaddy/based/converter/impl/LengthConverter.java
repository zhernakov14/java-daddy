package ru.andr.javadaddy.based.converter.impl;

import ru.andr.javadaddy.based.converter.BaseConverter;
import ru.andr.javadaddy.based.converter.exception.ConversionException;
import ru.andr.javadaddy.based.converter.util.ConverterUtil;
import ru.andr.javadaddy.based.unit.LengthUnit;

public class LengthConverter extends ConverterUtil implements BaseConverter<LengthUnit>  {

    private static final Double METER_KILOMETER = 1000.00;
    private static final Double METER_MILE = 1609.34;

    @Override
    public void convert(Double value, String fromUnit, String toUnit) throws ConversionException {

        LengthUnit fromUnitEnum = parseUnit(LengthUnit.class, fromUnit);
        LengthUnit toUnitEnum = parseUnit(LengthUnit.class, toUnit);

        double inMeters = toMeters(value, fromUnitEnum);
        double result = fromMeters(inMeters, toUnitEnum);

        System.out.printf("%.2f %s = %.2f %s%n", value, fromUnit, result, toUnit);
    }

    private double toMeters(double value, LengthUnit unit) {
        return switch (unit) {
            case KILOMETER -> value * METER_KILOMETER;
            case MILE -> value * METER_MILE;
            default -> value;
        };
    }

    private double fromMeters(double meters, LengthUnit unit) {
        return switch (unit) {
            case KILOMETER -> meters / METER_KILOMETER;
            case MILE -> meters / METER_MILE;
            default -> meters;
        };
    }
}
