package ru.andr.javadaddy.based.unit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LengthUnit {

    METER("meter"),
    KILOMETER("kilometer"),
    MILE("mile");

    private final String unitName;
}
