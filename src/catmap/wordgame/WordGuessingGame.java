package catmap.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    public WordGuessingGame(String[] wordsList, int maxAttempts) {
        Random rand = new Random();
        this.wordToGuess = wordsList[rand.nextInt(wordsList.length)];
        this.guessedLetters = new char[this.wordToGuess.length()];
        for (int i = 0; i < this.guessedLetters.length; i++) {
            this.guessedLetters[i] = '_';
        }
        this.attempts = maxAttempts;
    }

    public void play() {
        //System.out.println("The word is: " + wordToGuess);

        Scanner scanner = new Scanner(System.in);
        boolean gameIsOver = false;

        while (attempts > 0 && !gameIsOver) {
            displayState();
            System.out.println("\nYou have " + attempts + " left.");
            System.out.println("Guess a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (processGuess(guess)) {
                System.out.println("*** Correct!. Letters guessed: " + guessedLetters + "***");
                if (new String(guessedLetters).equals(wordToGuess)) {
                    System.out.println("You have guessed the word!");
                    //break;
                    gameIsOver = true;
                }

            } else {
                System.out.println("--- That guess was incorrect. ---");
                attempts--;
            }
        }
        if(attempts == 0){
            System.out.println("Maximum attempts reached... The word was: \"" + wordToGuess + "\" Game Over!");

        }
    }

    private boolean processGuess ( char letter){
        boolean letterFound = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedLetters[i] = letter;
                letterFound = true;
            }
        }
        return letterFound;
    }

    private void displayState(){
        System.out.println("Guessed Letters: " + new String(guessedLetters));
    }
}


