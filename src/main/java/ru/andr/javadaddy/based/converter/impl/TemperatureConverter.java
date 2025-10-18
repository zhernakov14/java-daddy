package ru.andr.javadaddy.based.converter.impl;

import ru.andr.javadaddy.based.converter.BaseConverter;
import ru.andr.javadaddy.based.exception.ConversionException;
import ru.andr.javadaddy.based.unit.TemperatureUnit;

public class TemperatureConverter implements BaseConverter<TemperatureUnit> {

    private static final Double CELSIUS_FAHRENHEIT = 1.8;
    private static final Double CELSIUS_KELVIN = 273.15;

    @Override
    public void convert(Double value, TemperatureUnit fromUnit, TemperatureUnit toUnit) {

        double inMeters = toCelsius(value, fromUnit);
        double result = fromCelsius(inMeters, toUnit);

        System.out.printf("%.2f %s = %.2f %s%n", value, fromUnit, result, toUnit);
    }

    @Override
    public TemperatureUnit parseUnit(String unitStr) throws ConversionException {
        try {
            return TemperatureUnit.valueOf(unitStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ConversionException("Unknown unit: " + unitStr);
        }
    }

    private double toCelsius(double value, TemperatureUnit unit) {
        return switch (unit) {
            case FAHRENHEIT -> (value - 32) / CELSIUS_FAHRENHEIT;
            case KELVIN -> value - CELSIUS_KELVIN;
            default -> value;
        };
    }

    private double fromCelsius(double celsius, TemperatureUnit unit) {
        return switch (unit) {
            case FAHRENHEIT -> celsius * CELSIUS_FAHRENHEIT + 32;
            case KELVIN -> celsius + CELSIUS_KELVIN;
            default -> celsius;
        };
    }
}
