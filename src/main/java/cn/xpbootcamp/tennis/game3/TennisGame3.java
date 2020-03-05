package cn.xpbootcamp.tennis.game3;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame3 implements TennisGame {

    private static final String DEUCE = "Deuce";
    private int player1;
    private int player2;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (player1 < 4 && player2 < 4 && !(player1 + player2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            return (player1 == player2) ? p[player1] + "-All" : p[player1] + "-" + p[player2];
        } else {
            return (player1 == player2) ?
                    DEUCE
                    : getResult();
        }
    }

    private String getResult() {
        return ((player1 - player2) * (player1 - player2) == 1) ? "Advantage " + getPlayerName() : "Win for " + getPlayerName();
    }

    private String getPlayerName() {
        return player1 > player2 ? player1Name : player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.player1 += 1;
        else
            this.player2 += 1;
    }

}
