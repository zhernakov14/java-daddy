package ru.andr.javadaddy.based.converter;

import ru.andr.javadaddy.based.exception.ConversionException;

public interface BaseConverter<T extends Enum<T>> {

    void convert(Double value, T fromUnit, T toUnit) throws ConversionException;

    T parseUnit(String unitStr) throws ConversionException;
}
