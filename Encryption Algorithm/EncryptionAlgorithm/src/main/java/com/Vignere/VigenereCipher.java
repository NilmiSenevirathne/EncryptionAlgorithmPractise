package com.Vignere;

import java.util.Scanner;

public class VigenereCipher {

    // Method to encrypt plaintext using the Vigenère cipher
    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        key = generateKey(plaintext, key); // Extend the key to match plaintext length

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);

            if (Character.isUpperCase(plainChar)) {
                int shift = key.charAt(i) - 'A';
                char encryptedChar = (char) ((plainChar - 'A' + shift) % 26 + 'A');
                ciphertext.append(encryptedChar);
            } else if (Character.isLowerCase(plainChar)) {
                int shift = key.charAt(i) - 'A';
                char encryptedChar = (char) ((plainChar - 'a' + shift) % 26 + 'a');
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(plainChar); // Non-alphabetic characters remain unchanged
            }
        }

        return ciphertext.toString();
    }

    // Method to decrypt ciphertext using the Vigenère cipher
    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        key = generateKey(ciphertext, key); // Extend the key to match ciphertext length

        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);

            if (Character.isUpperCase(cipherChar)) {
                int shift = key.charAt(i) - 'A';
                char decryptedChar = (char) ((cipherChar - 'A' - shift + 26) % 26 + 'A');
                plaintext.append(decryptedChar);
            } else if (Character.isLowerCase(cipherChar)) {
                int shift = key.charAt(i) - 'A';
                char decryptedChar = (char) ((cipherChar - 'a' - shift + 26) % 26 + 'a');
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(cipherChar); // Non-alphabetic characters remain unchanged
            }
        }

        return plaintext.toString();
    }


    // Method to extend the key to match the length of the text
    private static String generateKey(String text, String key) {
        StringBuilder extendedKey = new StringBuilder(key);
        while (extendedKey.length() < text.length()) {
            extendedKey.append(key);
        }
        return extendedKey.substring(0, text.length()).toUpperCase();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input plaintext and key
        System.out.println("Enter the plaintext:");
        String plaintext = scanner.nextLine();

        System.out.println("Enter the key:");
        String key = scanner.nextLine();

        // Encrypt the plaintext
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);

        // Decrypt the ciphertext
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}
