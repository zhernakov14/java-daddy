package ru.andr.javadaddy.based.unit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WeightUnit {

    KILOGRAM("kilogram"),
    POUND("pound"),
    OUNCE("ounce");

    private final String unit;
}
