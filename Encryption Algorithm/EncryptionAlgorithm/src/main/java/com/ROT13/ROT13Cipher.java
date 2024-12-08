package com.ROT13;

import java.util.Scanner;

public class ROT13Cipher {

    //method to apply ROT13 to  given string
    public static String applyROT13(String input)
    {
        StringBuilder result  = new StringBuilder();

        for(char c : input.toCharArray()){
             if (Character.isUpperCase(c))
             {
                 char rotatedChar = (char) ((c- 'A'+13) % 26 + 'A');
                 result.append(rotatedChar);

             } else if (Character.isLowerCase(c)) {

                 char rotatedChar = (char) ((c - 'a'+13) %26 +'a');
                 result.append(rotatedChar);

             }else {
                 result.append(c);
             }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        //input the text
        System.out.println(" enter the plain text: ");
        String plaintext = scanner.nextLine();


        //apply ROT13
        String encodedText = applyROT13(plaintext);
        System.out.println(" encoded text = " +encodedText);

        //apply ROT13 again decodes the text
        String decodedText = applyROT13(encodedText);
        System.out.println(" decoded text = "+decodedText);

        scanner.close();
    }


}
