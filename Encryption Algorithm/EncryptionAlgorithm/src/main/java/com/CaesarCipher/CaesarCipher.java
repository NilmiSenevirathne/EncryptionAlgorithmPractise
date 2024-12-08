package com.CaesarCipher;

import java.util.Scanner;

public class CaesarCipher {


    //method to encrypt the plaintext
    public static String encrypt(String plaintext,int key)
    {
        StringBuilder ciphertext = new StringBuilder();

        for(char c: plaintext.toCharArray())
        {
             if(Character.isUpperCase(c))
             {
                 //Shift uppercase letters
                 char encryptedChar = (char) ((c-'A' +key) % 26 + 'A');
                 ciphertext.append(encryptedChar);

             } else if (Character.isLowerCase(c)) {

                 //Shift lowercase letters
                 char encryptedChar = (char) ((c - 'a' +key) % 26 + 'a');
                 ciphertext.append(encryptedChar);

             }else {
                 //leave non-alphabetic characters unchanged
                 ciphertext.append(c);
             }
        }

        return ciphertext.toString();
    }

    //method to decrypt the ciphertext
    public static String decrypt(String ciphertext,int key)
    {
        StringBuilder plaintext = new StringBuilder();

        for(char c: ciphertext.toCharArray())
        {
            if (Character.isUpperCase(c)){

                //shift upper case letters backward
                char decryptedChar = (char) ((c - 'A' - key +26) %26 + 'A');
                plaintext.append(decryptedChar);

            } else if (Character.isLowerCase(c)) {

                char decryptedChar = (char) ((c - 'a' - key +26) % 26 + 'a');
                plaintext.append(decryptedChar);

            }else {
                plaintext.append(c);
            }
        }

        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input plaintext
        System.out.println(" Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        //caesar cipher key
        int key = 3; //fixed shift value

        //encrypted the cipher text
        String ciphertext = encrypt(plaintext,key);
        System.out.println(" Encrypted text : "+ciphertext);

        //decrypted the cipher text
        String decryptedText = decrypt(ciphertext,key);
        System.out.println(" Decrypted text: "+decryptedText);

        scanner.close();
    }


}
