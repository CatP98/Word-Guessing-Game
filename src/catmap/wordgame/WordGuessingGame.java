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
        System.out.println("The word is: " + wordToGuess);
        Scanner scanner = new Scanner(System.in);

        while (attempts > 0) {
            System.out.println("You have "+ attempts + " left.");
            System.out.println("Guess a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if(!processGuess(guess)){
                System.out.println("That guess was imcorrect.");
                attempts--;
            }
            else {
                //guessedLetters.add(guess);
                System.out.println("Correct!. Letters guessed: " + guessedLetters);
            }


        }

    }

    private boolean processGuess(char letter){
        boolean letterFound = false;

        for(int i = 0; i < wordToGuess.length(); i++){
            if(wordToGuess.charAt(i) == letter) {
                guessedLetters[i] = letter;
                letterFound = true;
            }
        }
        return letterFound;
    }
}
