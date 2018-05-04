package pl.bekz.controller;

import pl.bekz.model.Player.Player;
import pl.bekz.model.Player.impl.Computer;
import pl.bekz.model.Player.impl.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerManager {
    private Player humanPlayer = new Human();
    private Player computerPlayer = new Computer();
    protected List<Player> playersList = new ArrayList(  );

    void addPlayers(){
        playersList.add( humanPlayer );
        playersList.add( computerPlayer );
    }

    Player firstPlayer(){
        return playersList.get( 0 );
    }

    Player secondPlayer(){
        return playersList.get( 1 );
    }

    void randomPlayer(){
        Collections.shuffle( playersList );
    }

}
