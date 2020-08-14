package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String userInput;
        do {
            System.out.println("Write two words:");
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextLine();

            try {
                System.out.println(wordConversion(userInput));
            } catch (Exception ex) {
                //do-nothing
            }

        } while(!userInput.equals("exit"));

        System.out.println("Exiting...");

    }



    static int wordConversion(String input) {

        String[] inputArray = input.split(" ");
        String firstWord = inputArray[0];
        String secondWord = inputArray[1];

        if (firstWord.length() != secondWord.length()) {
            return 0;
        }

        ArrayList<Character> array1 = new ArrayList<Character>();
        ArrayList<Character> array2 = new ArrayList<Character>();

        for (int i = 0; i < firstWord.length(); i++) {
            char letter1 = firstWord.charAt(i);
            char letter2 = secondWord.charAt(i);

            //add if to it
            int index = array1.indexOf(letter1);
            if (array1.contains(letter1) && (letter1 == firstWord.charAt(index) && letter2 != secondWord.charAt(index))) {
                return 0;
            }
            array1.add(letter1);
            array2.add(letter2);
        }

        return 1;
    }
}




