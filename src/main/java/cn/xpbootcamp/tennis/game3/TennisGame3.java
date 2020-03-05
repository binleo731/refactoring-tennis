package cn.xpbootcamp.tennis.game3;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame3 implements TennisGame {

    private int player1;
    private int player2;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String s;
        if (player1 < 4 && player2 < 4 && !(player1 + player2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[player1];
            return (player1 == player2) ? s + "-All" : s + "-" + p[player2];
        } else {
            if (player1 == player2)
                return "Deuce";
            s = player1 > player2 ? player1Name : player2Name;
            return ((player1 - player2)*(player1 - player2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.player1 += 1;
        else
            this.player2 += 1;

    }

}
