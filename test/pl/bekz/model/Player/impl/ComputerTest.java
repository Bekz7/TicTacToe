package pl.bekz.model.Player.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.bekz.model.GameFigures;
import pl.bekz.view.PlayerDecisionView;

import java.util.Objects;

public class ComputerTest implements GameFigures {
    private Computer sut;
    private final int ROW_OF_THE_BOARD = 3;
    private final int COLUMN_OF_THE_BOARD = 3;

    @Before
    public void setUp() throws Exception {
        sut = new Computer();
    }

    @Test
    public void firstSignTest() {
        //Given
        int pointedRow = 0;
        int pointedColumn = 0;

        sut.setCurrentBoard( pointFirsSign( pointedRow, pointedColumn ) );
        char[][] firstSignBoard = sut.getCurrentBoard();
        sut.makeMove();

        //When
        boolean result = Objects.equals( firstSignBoard, sut.getCurrentBoard() );
        PlayerDecisionView.board( sut.getCurrentBoard() );
        //Then
        Assert.assertTrue( result );
    }

    private char[][] pointFirsSign(int row, int column) {
        char[][] result = new char[ROW_OF_THE_BOARD][COLUMN_OF_THE_BOARD];
        result[row][column] = NOUGHT_SIGN;
        return result;
    }

    private char[][] fullBoard() {
        char[][] result = new char[ROW_OF_THE_BOARD][COLUMN_OF_THE_BOARD];
        for (int i = 0; i < ROW_OF_THE_BOARD; i++) {
            for (int j = 0; j < COLUMN_OF_THE_BOARD; j++) {
                result[i][j] = CROSS_SIGN;
            }
        }
        return result;

    }
}