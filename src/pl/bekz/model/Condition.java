package pl.bekz.model;


import pl.bekz.model.Board.Board;

import java.util.ArrayList;
import java.util.List;

public class Condition implements GameFigures {
    private List<Character> crosses = new ArrayList<>();
    private List<Character> noughts = new ArrayList<>();
    private List<Character> gameSings = new ArrayList<>();
    private char[][] currentGameBoard;

    public Condition() {
        gameSings.clear();
        this.currentGameBoard = Board.currentGameBoard;
    }

    public char[][] getCurrentGameBoard() {
        return currentGameBoard;
    }

    public void setCurrentGameBoard(char[][] currentGameBoard) {
        this.currentGameBoard = currentGameBoard;
    }

    public boolean draw() {
        if (boardIsFull()) {
            return true;
        }
        return false;
    }

    boolean boardIsFull() {
        for (char[] aGameBoard : currentGameBoard) {
            for (char anAGameBoard : aGameBoard) {
                if (anAGameBoard != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean rowWin() {
        fillLists();
        for (char[] aCurrentGameBoard : currentGameBoard) {
            for (int j = 0; j < aCurrentGameBoard.length; j++) {
                if (isTheSignAreTheSame( aCurrentGameBoard[j] )) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean columnWin() {
        fillLists();
        for (int i = 0; i < currentGameBoard.length; i++) {
            for (int j = 0; j < currentGameBoard[i].length; j++) {
                if (isTheSignAreTheSame( currentGameBoard[j][i] )) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean firstDiagonalWin() {
        fillLists();
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (isTheSignAreTheSame( currentGameBoard[i][i] )) {
                return true;
            }
        }
        return false;
    }


    public boolean secondDiagonalWin() {
        fillLists();
        for (int i = 0; i < currentGameBoard.length; i++) {
            int j;
            j = currentGameBoard.length - 1;
            if (isTheSignAreTheSame( currentGameBoard[i][j - i] )) {
                return true;
            }
        }
        return false;
    }

    private void fillLists() {
        this.crosses = crossList();
        this.noughts = noughtList();
    }

    private boolean isTheSignAreTheSame(char sign) {
        putSignToCheck( sign );
        return isCrossWin() || isNoughtWin();
    }

    private boolean isCrossWin() {
        return crosses.equals( gameSings );
    }

    private boolean isNoughtWin() {
        return noughts.equals( gameSings );
    }

    private void putSignToCheck(char sign) {
        if (isCellNotEmpty( sign )) {
            gameSings.add( sign );
        }
    }

    private boolean isCellNotEmpty(char sign) {
        return sign != '\u0000';
    }

    private List<Character> crossList() {
        List<Character> results = new ArrayList<>();
        for (int i = 0; i < currentGameBoard.length; i++) {
            results.add( i, CROSS_SIGN );
        }
        return results;
    }

    private List<Character> noughtList() {
        List<Character> results = new ArrayList<>();
        for (int i = 0; i < currentGameBoard.length; i++) {
            results.add( i, NOUGHT_SIGN );
        }
        return results;
    }

}
