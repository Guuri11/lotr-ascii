package com.guuri11.lotrascii.console;

import com.guuri11.lotrascii.ascii.Emojis;

import java.util.Scanner;

/**
 * Console
 */
public class Console {

    public static void clearConsole(final int waitMillis) {
        try {
            Thread.sleep(waitMillis);
            System.out.println("Clearing debug, remove me before production");

            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }

    public static int getInputInt(Scanner in, int range) {
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                int val = in.nextInt();
                if (val >= 1 && val <= range) { // <-- from "0" to "range".
                    return val;
                }
            } else {
                in.next();
            }
        }
        return -1;
    }

}
