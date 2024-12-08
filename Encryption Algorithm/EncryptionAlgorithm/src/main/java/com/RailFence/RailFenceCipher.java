package com.RailFence;

import java.util.Scanner;

public class RailFenceCipher {

    // Method to encrypt plaintext using the Rail Fence Cipher
    public static String encrypt(String plaintext, int rails) {
        if (rails <= 1) return plaintext;

        // Create an array of StringBuilder to hold the characters for each rail
        StringBuilder[] rail = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) {
            rail[i] = new StringBuilder();
        }

        // Zigzag pattern: Direction control
        int currentRail = 0;
        boolean directionDown = true;

        for (char c : plaintext.toCharArray()) {
            // Add character to the current rail
            rail[currentRail].append(c);

            // Change direction if we hit the top or bottom rail
            if (currentRail == 0) {
                directionDown = true;
            } else if (currentRail == rails - 1) {
                directionDown = false;
            }

            // Move up or down the rails
            currentRail += directionDown ? 1 : -1;
        }

        // Combine all the rails to form the ciphertext
        StringBuilder ciphertext = new StringBuilder();
        for (StringBuilder r : rail) {
            ciphertext.append(r);
        }

        return ciphertext.toString();
    }

    // Method to decrypt ciphertext using the Rail Fence Cipher
    public static String decrypt(String ciphertext, int rails) {
        if (rails <= 1) return ciphertext;

        // Create an array to mark the zigzag pattern
        char[] marker = new char[ciphertext.length()];
        int currentRail = 0;
        boolean directionDown = true;

        // Mark the zigzag pattern
        for (int i = 0; i < marker.length; i++) {
            marker[i] = (char) currentRail;

            if (currentRail == 0) {
                directionDown = true;
            } else if (currentRail == rails - 1) {
                directionDown = false;
            }

            currentRail += directionDown ? 1 : -1;
        }

        // Fill rails with characters from the ciphertext
        StringBuilder[] rail = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) {
            rail[i] = new StringBuilder();
        }

        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < marker.length; j++) {
                if (marker[j] == i) {
                    rail[i].append(ciphertext.charAt(index++));
                }
            }
        }

        // Read the rails in a zigzag pattern to decrypt
        StringBuilder plaintext = new StringBuilder();
        currentRail = 0;
        directionDown = true;
        for (int i = 0; i < ciphertext.length(); i++) {
            plaintext.append(rail[currentRail].charAt(0));
            rail[currentRail].deleteCharAt(0);

            if (currentRail == 0) {
                directionDown = true;
            } else if (currentRail == rails - 1) {
                directionDown = false;
            }

            currentRail += directionDown ? 1 : -1;
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input plaintext and number of rails
        System.out.println("Enter the plaintext:");
        String plaintext = scanner.nextLine();

        System.out.println("Enter the number of rails:");
        int rails = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Encrypt the plaintext
        String ciphertext = encrypt(plaintext, rails);
        System.out.println("Ciphertext: " + ciphertext);

        // Decrypt the ciphertext
        String decryptedText = decrypt(ciphertext, rails);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}
