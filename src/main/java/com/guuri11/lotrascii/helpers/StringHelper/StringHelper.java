package com.guuri11.lotrascii.helpers.StringHelper;

public class StringHelper {
    public static String getLastWord(String input) {
        // Trim any leading or trailing whitespace
        input = input.trim();

        // Split the string by spaces
        String[] words = input.split("\\s+");

        // Return the last word after removing any trailing punctuation
        if (words.length > 0) {
            return words[words.length - 1].replaceAll("[^a-zA-Z_]", "");
        } else {
            return ""; // Return an empty string if there are no words
        }
    }

    public static String removeLastWord(String input) {
        // Trim any leading or trailing whitespace
        input = input.trim();

        // Find the position of the last space
        int lastSpaceIndex = input.lastIndexOf(" ");

        // Return the string without the last word
        if (lastSpaceIndex != -1) {
            return input.substring(0, lastSpaceIndex).trim();
        } else {
            return input; // Return the original string if there are no spaces
        }
    }

}
