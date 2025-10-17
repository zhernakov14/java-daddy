package ru.andr.javadaddy.based.unit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemperatureUnit {

    CELSIUS("celsius"),
    FAHRENHEIT("fahrenheit"),
    KELVIN("kelvin");

    private final String unit;
}
