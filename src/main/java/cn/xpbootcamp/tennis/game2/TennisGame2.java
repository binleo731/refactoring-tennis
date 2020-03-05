package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    private static final String PLAYER_NAME = "player1";
    private int P1point = 0;
    private int P2point = 0;

    public String getScore() {
        if (getWinResult() != null) return getWinResult();

        return isSamePoint()
                ? getPlayerScore(P1point) + "-All"
                : getPlayerScore(P1point) + "-" + getPlayerScore(P2point);
    }

    private boolean isSamePoint() {
        return P1point == P2point;
    }

    private String getWinResult() {
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            return "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            return "Win for player2";
        }
        if (P1point > P2point && P2point >= 3) {
            return "Advantage player1";
        }
        if (P2point > P1point && P1point >= 3) {
            return "Advantage player2";
        }

        if (isSamePoint()) return "Deuce";

        return null;
    }

    private String getPlayerScore(int player) {
        String[] score = {"Love", "Fifteen", "Thirty", "Forty"};
        return score[player];
    }

    public void wonPoint(String player) {
        if (player.equals(PLAYER_NAME))
            P1point++;
        else
            P2point++;
    }
}
