package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int score1 = 0;
    private int score2 = 0;


    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            score1 += 1;
        else
            score2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        if (score1 == score2) {
            switch (score1) {
                case 0:
                    score = new StringBuilder("Love-All");
                    break;
                case 1:
                    score = new StringBuilder("Fifteen-All");
                    break;
                case 2:
                    score = new StringBuilder("Thirty-All");
                    break;
                default:
                    score = new StringBuilder("Deuce");
                    break;

            }
        } else if (score1 >= 4 || score2 >= 4) {
            int minusResult = score1 - score2;
            if (minusResult == 1) score = new StringBuilder("Advantage player1");
            else if (minusResult == -1) score = new StringBuilder("Advantage player2");
            else if (minusResult >= 2) score = new StringBuilder("Win for player1");
            else score = new StringBuilder("Win for player2");
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = score1;
                else {
                    score.append("-");
                    tempScore = score2;
                }
                if (tempScore == 0) {
                    score.append("Love");
                } else if (tempScore == 1) {
                    score.append("Fifteen");
                } else if (tempScore == 2) {
                    score.append("Thirty");
                } else if (tempScore == 3) {
                    score.append("Forty");
                }
            }
        }
        return score.toString();
    }
}
