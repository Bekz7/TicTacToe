package pl.bekz.model.Player.impl;

import pl.bekz.model.Board.Board;
import pl.bekz.model.GameFigures;
import pl.bekz.model.Player.Player;

import java.util.Scanner;

public class Human implements Player, GameFigures {
    private Scanner in = new Scanner( System.in );
    private char[][] currentBoard;
    String respond;


    public Human() {
        this.currentBoard = Board.currentGameBoard;
    }

    public char[][] getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentGameBoard(char[][] currentGameBoard) {
        currentBoard = currentGameBoard;
    }

    @Override
    public void makeMove() {
        try {
            int row = pointTheRow();
            int column = pointTheColumn();
            if (isCellEmpty( row, column )) {
                currentBoard[row][column] = CROSS_SIGN;
            } else {
                respond ="Cell is occupied, try another one";
                System.out.println( respond );
                makeMove();
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            respond ="You point wrong,  try with number from: 0 to: " + currentBoard.length;
            System.out.println( respond );
            makeMove();
        }
    }

    @Override
    public int pointTheRow() {
        return in.nextInt();
    }

    @Override
    public int pointTheColumn() {
        return in.nextInt();
    }

    @Override
    public boolean isCellEmpty(int row, int column) {
        return currentBoard[row][column] == '0';
    }
}
