package com.guuri11.lotrascii.game.menu;

import com.guuri11.lotrascii.ascii.Emojis;
import com.guuri11.lotrascii.console.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Menu
 */
public class Menu {

    private List<Option> options = new ArrayList<>();
    private Option optionSelected;
    private static String menuScreen = """
            Menú

            1. Nueva partida
            2. Salir
            """;

    public Menu() {
        this.optionSelected = null;
        this.options.add(Option.NEW_GAME);
        this.options.add(Option.EXIT);
    }

    public void load() {
        System.out.println(menuScreen);
        Scanner scanner = new Scanner(System.in);
        System.out.print(Emojis.ARROW_RIGHT);
        int option = Console.getInputInt(scanner, options.size());
        optionSelected = options.get(option - 1);
    }

    public Option getOption() {
        return this.optionSelected;
    }
}
