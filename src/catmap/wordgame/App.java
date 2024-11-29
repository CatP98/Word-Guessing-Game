package catmap.wordgame;

public class App {
    public static void main(String[] args) {
        String[] easyWords = new String[] {"java", "programming", "class", "computer", "method"};
        WordGuessingGame game = new WordGuessingGame(easyWords, 2);

        game.play();
    }
}
