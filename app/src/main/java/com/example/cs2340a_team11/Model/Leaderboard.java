package com.example.cs2340a_team11.Model;




import java.util.*;
public class Leaderboard {

    /**
     * Unique instance of leaderboard.
     * Created in order to adhere with
     * Singleton design pattern.
     */
    private static Leaderboard uniqueInstance;

    /**
     * List of Scores
     */
    private ArrayList<Score> scores;

    /**
     * Private constructor for Leaderboard.
     */
    private Leaderboard() {
        scores = new ArrayList<>();
    }

    /** Creates (if needed) and returns
     * an instance of Leaderboard.
     * @return current Leaderboard instance
     */
    public static Leaderboard getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Leaderboard();
        }
        return uniqueInstance;
    }


    /**
     * Adds score to list of scores (not sorted)
     * @param playerName playerName
     * @param score player's score on recent attempt
     */
    public void addScore(String playerName, int score) {
        String dateTime = ""; //FIGURE OUT HOW TO GET DATE/TIME
        scores.add(new Score(playerName, score, dateTime));
    }

    /**
     * Returns the top scores by first ordering the
     * scores list.
     * @param numScoresToDisplay how many top score to show
     * @return list containing numScoresToDisplay topScores
     */
    public ArrayList<Score> getTopScores(int numScoresToDisplay) {
        Collections.sort(scores, Collections.reverseOrder());
        ArrayList<Score> highestScores = new ArrayList<>();

        if (scores.size() < numScoresToDisplay) {
            numScoresToDisplay = scores.size();
        }

        for (int i = 0; i < numScoresToDisplay; i++) {
            highestScores.add(scores.get(i));
        }

        return highestScores;
    }


    /**
     * getter for scores list
     * @return the list of scores
     */
    public ArrayList<Score> getScores() {
        return scores;
    }

    /**
     * setter for scores list
     * @param scores the list of scores to set scores to
     */
    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }


    private class Score {
        private String playerName;
        private int score;
        private String dateTime;

        public Score(String playerName) {
            this.playerName = playerName;
        }

        public Score(String playerName, int score, String dateTime) {
            this.playerName = playerName;
            this.score = score;
            this.dateTime = dateTime;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }


        @Override
        public String toString() {
            return "PlayerName=" + playerName +
                    ", score=" + score +
                    ", dateTime=" + dateTime;
        }
    }

}
