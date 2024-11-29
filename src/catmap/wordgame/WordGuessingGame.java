package catmap.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;

    public WordGuessingGame(String[] wordsList, int maxAttempts){
        Random rand = new Random();
        this.wordToGuess = wordsList[rand.nextInt(wordsList.length)];
        this.guessedLetters = new char[this.wordToGuess.length()];
        for(int i = 0; i < this.guessedLetters.length; i++){
            this.guessedLetters[i] = '_';


        }
        this.attempts = maxAttempts;
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);

        while (attempts > 0) {
            System.out.println("You have "+ attempts + " left.");
            System.out.println("Guess a letter: ");


            attempts--;
        }
    }
}
