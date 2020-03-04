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
        if (score1 == score2) {
            return getAllScore();
        } else if (score1 >= 4 || score2 >= 4) {
            return getWinResult();
        } else {
            return getEveryPlayerScore();
        }
    }

    private String getEveryPlayerScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = score1;
            } else {
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
        return score.toString();
    }

    private String getWinResult() {
        int minusResult = score1 - score2;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getAllScore() {
        switch (score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
