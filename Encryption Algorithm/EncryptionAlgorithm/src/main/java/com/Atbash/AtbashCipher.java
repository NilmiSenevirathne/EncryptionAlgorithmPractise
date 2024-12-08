package com.Atbash;

import java.util.Scanner;

public class AtbashCipher {

    // Method to apply Atbash cipher to a given string
    public static String applyAtbash(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // Reverse uppercase letters
                char transformedChar = (char) ('Z' - (c - 'A'));
                result.append(transformedChar);
            } else if (Character.isLowerCase(c)) {
                // Reverse lowercase letters
                char transformedChar = (char) ('z' - (c - 'a'));
                result.append(transformedChar);
            } else {
                // Leave non-alphabetic characters unchanged
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input plaintext
        System.out.println("Enter text to encode/decode with Atbash:");
        String plaintext = scanner.nextLine();

        // Apply Atbash cipher
        String transformedText = applyAtbash(plaintext);
        System.out.println("Transformed text: " + transformedText);

        scanner.close();
    }
}
