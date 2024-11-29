package catmap.wordgame;

public class Stats {
    private int totalGames;
    private int lostGames;
    private int wonGames;

    // Constructor to initialize the stats to zero
    public Stats() {
        totalGames = 0;
        lostGames = 0;
        wonGames = 0;
    }

    // Increment the total game count
    public void incrementTotalGames() {
        totalGames++;
    }

    // Increment the won games count
    public void incrementWonGames() {
        wonGames++;
    }

    // Increment the lost games count
    public void incrementLostGames() {
        lostGames++;
    }

    // Getters
    public int getTotalGames() {
        return totalGames;
    }

    public int getWonGames() {
        return wonGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Total Games: " + totalGames + "\n" +
                "Won Games: " + wonGames + "\n" +
                "Lost Games: " + lostGames;
    }
}
