package pl.bekz.controller;


import pl.bekz.model.Board.Board;
import pl.bekz.view.MenuView;
import pl.bekz.view.PlayerDecisionView;

public class Game {
    GameManager manager = new GameManager();
    MenuView menuView = new MenuView();
    PlayerDecisionView playerDecisionView = new PlayerDecisionView();

    public void gameIntroduction(){
        menuView.introduction();
    }

    public void gameStartDecision(){
        playerDecisionView.startGame();
        if (manager.userChoose()){
            startRound();
        }
    }

    public void startRound(){
       while (!manager.isGameEnd()) {
           manager.quitTheGame();
           manager.startRound();
           playerDecisionView.makeYourMove();
           manager.playersMove();
           playerDecisionView.board( Board.currentGameBoard );
       }

    }

    public void roundIsOver(){
        playerDecisionView.rematch();
        if (manager.userChoose()){
            startRound();
        }
    }


}
