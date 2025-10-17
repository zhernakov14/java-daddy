package ru.andr.javadaddy.based.converter.util;

import ru.andr.javadaddy.based.converter.exception.ConversionException;

public class ConverterUtil {

    public <T extends Enum<T>> T parseUnit(Class<T> enumClass, String unitName) throws ConversionException {

        try {
            return Enum.valueOf(enumClass, unitName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ConversionException("Unknown " + enumClass.getSimpleName() + ": "  + unitName);
        }
    }
}