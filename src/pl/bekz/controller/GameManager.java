package pl.bekz.controller;

import pl.bekz.model.Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    Condition gameCondition = new Condition();
    PlayerManager players = new PlayerManager();
    List<Boolean> endGameCondition = new ArrayList<>();

    void startRound() {
        players.addPlayers();
        players.randomPlayer();
    }

    void playersMove() {
       players.firstPlayer().makeMove();
       players.secondPlayer().makeMove();
    }

    void quitTheGame() {
        if (isQuitting( )) {
            System.exit( 0 );
        }
    }

    boolean isQuitting() {
        Scanner in = new Scanner( System.in );
        String quit = in.nextLine();
        return "q".equalsIgnoreCase( quit );
    }

    boolean isGameEnd() {
        return endGameCondition.contains( true );
    }

    private List FinishTheGame() {
        endGameCondition.add( gameCondition.columnWin() );
        endGameCondition.add( gameCondition.rowWin() );
        endGameCondition.add( gameCondition.draw() );
        endGameCondition.add( gameCondition.firstDiagonalWin() );
        endGameCondition.add( gameCondition.secondDiagonalWin() );
        return endGameCondition;
    }

  public   boolean userChoose() {
        Scanner in = new Scanner( System.in );
        String userDecision = in.nextLine();
        return "y".equalsIgnoreCase( userDecision );
    }

}


