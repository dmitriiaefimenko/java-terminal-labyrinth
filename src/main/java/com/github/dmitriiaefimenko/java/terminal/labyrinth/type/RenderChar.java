package com.github.dmitriiaefimenko.java.terminal.labyrinth.type;

public interface RenderChar {

    char HUNTER_NEAR            = 'O';
    char HUNTER_DISTANT         = ':';

    char CARD_NEAR              = '#';
    char CARD_DISTANT           = ':';

    char WALL_NEAREST           = '\u2016';
    char WALL_NEAR              = '|';
    char WALL_DISTANT           = ':';

    char EXIT_NEAREST           = 'X';
    char EXIT_NEAR              = 'x';
    char EXIT_DISTANT           = '+';

    char WALL_EXIT_MOST_DISTANT = '\u00B7';

    char STAMINA_FULL           = '#';
    char STAMINA_EMPTY          = '_';

    char LOGO_1                 = 'X';
    char LOGO_2                 = 'x';

    char USER_HUNTER_1          = 'O';
    char USER_HUNTER_2          = 'o';
}
