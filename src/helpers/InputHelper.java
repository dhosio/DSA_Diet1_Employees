package helpers;

import java.util.Scanner;

/**
 * @author Daniel Githiomi
 */
public class InputHelper {
    private final Scanner reader;

    /**
     * Zero args constructor to create a new InputHelper instance
     */
    public InputHelper() {
        reader = new Scanner(System.in);
    }

    /**
     * Read character input from the user
     * @param prompt the string to be displayed before the input
     * @return the character input from the user
     */
    public char readCharacter(String prompt) {

        System.out.println(prompt + ": ");
        char inputText = reader.nextLine().charAt(0);
        return inputText;
    }

    /**
     * Read character input from the user giving a specific character range
     * @param prompt the string to be displayed before the input
     * @param validCharacters the valid character range
     * @return the character input from the user
     */
    public char readCharacter(String prompt, String validCharacters) {
        char inputText;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");
            inputText = reader.nextLine().toUpperCase().charAt(0);
            if (validCharacters.indexOf(inputText) == -1) {
                inputError = true;
                System.out.println("Character out of range: please re-enter: ");
            }
        } while (inputError);
        return inputText;
    }

    /**
     * Read string input from the user giving a specific character range
     * @param prompt the string to be displayed before the input
     * @return the string input from the user
     */
    public String readString(String prompt) {

        System.out.println(prompt + ": ");
        return reader.nextLine();
    }

    /**
     * Read integer input from the user giving a specific int range of max and min
     * @param prompt the string to be displayed before the input
     * @param max the maximum number for the input
     * @param min the minimum number for the input
     * @return the integer input from the user
     */
    public int readInt(String prompt, int max, int min) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
                if (inputNumber < min || inputNumber > max) {
                    inputError = true;
                    System.out.println("Number out of range: please re-enter\n");
                }
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

    /**
     * Read integer input from the user giving a specific int range of max and min
     * @param prompt the string to be displayed before the input
     * @return the integer input from the user
     */
    public int readInt(String prompt) {
        int inputNumber = 0;
        boolean inputError;
        do {
            inputError = false;
            System.out.println(prompt + ": ");

            try {
                inputNumber = Integer.parseInt(reader.nextLine());
            } catch (NumberFormatException e) {
                inputError = true;
                System.out.println("Not a valid number: please re-enter: ");
            }
        } while (inputError);
        return inputNumber;
    }

}
