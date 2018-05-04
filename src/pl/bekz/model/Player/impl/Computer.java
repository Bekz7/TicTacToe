package pl.bekz.model.Player.impl;

import pl.bekz.model.Board.Board;
import pl.bekz.model.GameFigures;
import pl.bekz.model.Player.Player;

import java.util.Random;

public class Computer implements Player, GameFigures {
    private char[][] currentBoard;
    private Random random = new Random();

    public Computer() {
        this.currentBoard = Board.currentGameBoard;
    }

    public char[][] getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(char[][] currentBoard) {
        this.currentBoard = currentBoard;
    }

    @Override
    public int pointTheRow() {
        return random.nextInt( currentBoard.length );
    }

    @Override
    public int pointTheColumn() {
        return random.nextInt( currentBoard.length );
    }

    @Override
    public void makeMove() {
        int row =pointTheRow();
        int column = pointTheColumn();

        if (isCellEmpty( row, column )) {
            currentBoard[row][column] = NOUGHT_SIGN;
        }else {
//            makeMove();
        }
    }

    @Override
    public boolean isCellEmpty(int row, int column) {
        return currentBoard[row][column] == '0';
    }
}
