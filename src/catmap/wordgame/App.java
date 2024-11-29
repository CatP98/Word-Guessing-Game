package catmap.wordgame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stats stats = new Stats();

        welcome();

        while (askPlayAgain(scanner)) {
            askPickTheme();

            int choice = scanner.nextInt();
            scanner.nextLine();

            // Handle invalid input for theme choice
            if (choice < 1 || choice > ThemePicker.values().length) {
                System.out.println("Invalid choice! Please pick a valid theme.");
                continue;  // Skip this iteration and ask for a valid choice
            }

            ThemePicker selectedTheme = ThemePicker.fromChoice(choice);
            String[] words = selectedTheme.getWords();

            WordGuessingGame game = new WordGuessingGame(words, 8);

            String result = game.play(scanner);

            stats.incrementTotalGames();
            System.out.println(stats);

            if(result.equals("win")){
                stats.incrementWonGames();
            } else if(result.equals("loss")){
                stats.incrementLostGames();
            }
        }
        System.out.println("\nGoodbye!");
    }

    private static void welcome(){
        System.out.println("******************************************************");
        System.out.println("*                                                    *");
        System.out.println("*       🎉 Welcome to the Word Guessing Game! 🎉     *");
        System.out.println("*                                                    *");
        System.out.println("* Guess the word letter by letter. You have limited  *");
        System.out.println("*    attempts, so think carefully! Good luck! 💪     *");
        System.out.println("*                                                    *");
        System.out.println("******************************************************");
        System.out.println();

    };

    private static void askPickTheme(){
        System.out.println("Choose a theme for the game:");
        System.out.println("1. Games");
        System.out.println("2. Movies");
        System.out.println("3. Animals");
        System.out.println("4. Countries");
        System.out.println("5. Mythology");
        System.out.println("6. Sports");
    }

    private static boolean askPlayAgain(Scanner scanner){
        System.out.println("Let's start the game? (Y/N)");
        String response = scanner.next().trim().toLowerCase();

        if(response.equals("y")){
            return true;
        }
        else {
            return false;
        }
    };
}
