package com.github.dmitriiaefimenko.java.terminal.labyrinth.unit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Card {

    public static final double CARD_SIZE = 0.15;

    private final double positionY;
    private final double positionX;
}
