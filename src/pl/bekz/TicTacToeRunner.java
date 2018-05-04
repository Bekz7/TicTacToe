package pl.bekz;


import pl.bekz.controller.Game;

public class TicTacToeRunner {
    public static void main(String[] args) {
        Game game = new Game();

        game.gameIntroduction();

        game.gameStartDecision();

        game.startRound();

        game.roundIsOver();

    }
}
