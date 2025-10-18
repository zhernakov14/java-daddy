package ru.andr.javadaddy.based.converter.impl;

import ru.andr.javadaddy.based.converter.BaseConverter;
import ru.andr.javadaddy.based.exception.ConversionException;
import ru.andr.javadaddy.based.unit.LengthUnit;

public class LengthConverter implements BaseConverter<LengthUnit>  {

    private static final Double METER_KILOMETER = 1000.00;
    private static final Double METER_MILE = 1609.34;

    @Override
    public void convert(Double value, LengthUnit fromUnit, LengthUnit toUnit) {

        double inMeters = toMeters(value, fromUnit);
        double result = fromMeters(inMeters, toUnit);

        System.out.printf("%.2f %s = %.2f %s%n", value, fromUnit, result, toUnit);
    }

    @Override
    public LengthUnit parseUnit(String unitStr) throws ConversionException {
        try {
            return LengthUnit.valueOf(unitStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ConversionException("Unknown unit: " + unitStr);
        }
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
