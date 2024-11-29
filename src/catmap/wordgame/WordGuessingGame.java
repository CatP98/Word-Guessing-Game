package catmap.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private String wordToGuess;
    private char[] guessedLetters;
    private int attempts;
    private Stats stats;

    public WordGuessingGame(String[] wordsList, int maxAttempts) {
        Random rand = new Random();
        this.stats = new Stats();
        this.wordToGuess = wordsList[rand.nextInt(wordsList.length)];
        this.guessedLetters = new char[this.wordToGuess.length()];
        for (int i = 0; i < this.guessedLetters.length; i++) {
            this.guessedLetters[i] = '_';
        }
        this.attempts = maxAttempts;
    }

    public void play(Scanner scanner) {
        stats.incrementTotalGames();
        //Scanner scanner = new Scanner(System.in);
        boolean gameIsOver = false;

        while (attempts > 0 && !gameIsOver) {
            displayState();
            System.out.println(stats);
            System.out.println("\n🔍 You have " + attempts + " attempts remaining.");
            System.out.print("👉 Enter your guess: \n");

            //char guess = scanner.nextLine().toLowerCase().charAt(0);

            String input = scanner.nextLine().toLowerCase().trim();

            // Ensure the input is not empty
            if (input.isEmpty()) {
                System.out.println("\n❌ ----- Please enter a valid letter! -----");
                continue; // Skip this iteration and prompt for input again
            }

            char guess = input.charAt(0);

            if (processGuess(guess)) {
                System.out.println("\n✅ ***** Correct! *****");
                if (new String(guessedLetters).equals(wordToGuess)) {
                    System.out.println("\n🎉🎉 Congratulations! You've guessed the word: \"" + wordToGuess + "\"! 🎉🎉");
                    stats.incrementWonGames();
                    gameIsOver = true;
                }
            } else {
                System.out.println("\n❌ ----- Incorrect guess! -----");
                attempts--;
            }
        }

        if(attempts == 0){
            stats.incrementLostGames();
            System.out.println("\n💀 Maximum attempts reached...");
            System.out.println("The correct word was: \"" + wordToGuess + "\"");
            System.out.println("💔 Better luck next time!");
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
        System.out.println("\n------------------------------------------------------");
        System.out.println("📝 Word to Guess: " + new String(guessedLetters));
        System.out.println("------------------------------------------------------");
    }

    public Stats getStats() {
        return stats;
    }
}


