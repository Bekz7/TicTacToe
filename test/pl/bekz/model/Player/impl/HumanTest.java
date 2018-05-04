package pl.bekz.model.Player.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.bekz.model.GameFigures;
import pl.bekz.view.PlayerDecisionView;

import java.util.Objects;

public class HumanTest implements GameFigures {
    private Human sut;
    private final int ROW_OF_THE_BOARD = 3;
    private final int COLUMN_OF_THE_BOARD = 3;

    @Before
    public void setUp() throws Exception {
        sut = new Human();
    }

    @Test
    public void pointTheSignOnFullBoard() {
        //given
        sut.setCurrentGameBoard( fullBoard() );
        sut.makeMove();

        //When
        String respond = "Cell is occupied, try another one";
        PlayerDecisionView.board( sut.getCurrentBoard() );
        //Then
        Assert.assertEquals( respond,sut.respond );
    }

    @Test
    public void wrongInputTest(){
        //Given
        sut.setCurrentGameBoard( fullBoard() );
        sut.makeMove();
        //When
        String respond = "You point wrong,  try with number from: 0 to: " + sut.getCurrentBoard().length;
        PlayerDecisionView.board( sut.getCurrentBoard() );
        //Then
        Assert.assertEquals( respond,sut.respond );
    }

    @Test
    public void firstSingTest() {
        //Given
        int pointedRow = 0;
        int pointedColumn = 0;

        sut.setCurrentGameBoard( pointFirsSign( pointedRow, pointedColumn ) );
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
        result[row][column] = CROSS_SIGN;
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