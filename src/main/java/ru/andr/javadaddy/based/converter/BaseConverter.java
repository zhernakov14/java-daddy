package ru.andr.javadaddy.based.converter;

import ru.andr.javadaddy.based.converter.exception.ConversionException;

public interface BaseConverter<T extends Enum<T>> {

    void convert(Double value, String fromUnit, String toUnit) throws ConversionException;
}
