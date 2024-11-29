package catmap.wordgame;

public enum ThemePicker {
    GAMES(new String[]{"minecraft", "fortnite", "overwatch", "valorant", "cyberpunk", "eldenring", "warcraft", "bioshock"}),
    MOVIES(new String[]{"inception", "avengers", "matrix", "godfather", "joker", "titanic", "gladiator", "interstellar"}),
    ANIMALS(new String[]{"elephant", "giraffe", "kangaroo", "alligator", "chimpanzee", "dolphin", "penguin", "rhinoceros"}),
    COUNTRIES(new String[]{"portugal", "canada", "brazil", "japan", "italy", "germany", "australia", "switzerland"}),
    MYTHOLOGY(new String[]{"zeus", "poseidon", "apollo", "medusa", "hades", "cerberus", "minotaur", "hercules"}),
    SPORTS(new String[]{"soccer", "baseball", "basketball", "tennis", "cricket", "volleyball", "rugby", "hockey"});

    private final String[] words;

    ThemePicker(String[] words) {
        this.words = words;
    }

    public String[] getWords() {
        return words;
    }

    public static ThemePicker fromChoice(int choice) {
        switch (choice) {
            case 1: return GAMES;
            case 2: return MOVIES;
            case 3: return ANIMALS;
            case 4: return COUNTRIES;
            case 5: return MYTHOLOGY;
            case 6: return SPORTS;
            default: return ANIMALS; // Default to Animals if input is invalid
        }
    }
}
