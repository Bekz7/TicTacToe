package pl.bekz.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.bekz.view.PlayerDecisionView;

public class ConditionTest implements GameFigures {
    private Condition sut;
//    private char[][] board = new char[3][3];

    @Before
    public void setUp() throws Exception {
        sut = new Condition();
    }

    @Test
    public void firstRowWin() {
        //Given
        final int FIRST_ROW = 0;
        sut.setCurrentGameBoard( fillRow( FIRST_ROW ) );

        //When
        boolean result = sut.rowWin();
        PlayerDecisionView.board( sut.getCurrentGameBoard() );

        //Then
        Assert.assertTrue( result );
    }

    @Test
    public void secondRowWin() {
        //Given
        final int SECOND_ROW = 1;
        sut.setCurrentGameBoard( fillRow( SECOND_ROW ) );

        //When
        boolean result = sut.rowWin();
        PlayerDecisionView.board( sut.getCurrentGameBoard() );

        //Then
        Assert.assertTrue( result );
    }

    @Test
    public void thirdRowWin() {
        //Given
        final int THIRD_ROW = 2;
        sut.setCurrentGameBoard( fillRow( THIRD_ROW ) );

        //When
        boolean result = sut.rowWin();
        PlayerDecisionView.board( sut.getCurrentGameBoard() );

        //Then
        Assert.assertTrue( result );
    }

    private char[][] fillRow(int index) {
        char[][] rowResult = new char[3][3];
        for (int i = 0; i < rowResult.length; i++) {
            rowResult[index][i] = CROSS_SIGN;
        }
        return rowResult;
    }

    @Test
    public void firstColumnWin() {
        //Given
        final int FIRST_COLUMN = 0;
        sut.setCurrentGameBoard( fillColumn( FIRST_COLUMN ) );

        //When
        boolean result = sut.columnWin();
        PlayerDecisionView.board( sut.getCurrentGameBoard() );

        //Then
        Assert.assertTrue( result );
    }

    @Test
    public void secondColumnWin() {
        //Given
        final int SECOND_COLUMN = 1;
        sut.setCurrentGameBoard( fillColumn( SECOND_COLUMN ) );

        //When
        boolean result = sut.columnWin();
        PlayerDecisionView.board( sut.getCurrentGameBoard() );

        //Then
        Assert.assertTrue( result );
    }

    @Test
    public void thirdColumnWin() {
        //Given
        final int THIRD_COLUMN = 2;
        sut.setCurrentGameBoard( fillColumn( THIRD_COLUMN ) );

        //When
        boolean result = sut.columnWin();
        PlayerDecisionView.board( sut.getCurrentGameBoard() );

        //Then
        Assert.assertTrue( result );
    }

    private char[][] fillColumn(int index) {
        char[][] columnResult = new char[3][3];
        for (int i = 0; i < columnResult.length; i++) {
            columnResult[i][index] = CROSS_SIGN;
        }
        return columnResult;
    }

    @Test
    public void firstDiagonalWin() {
        //Given
        sut.setCurrentGameBoard( fillFirstDiagonal() );

        // When
        boolean result = sut.firstDiagonalWin();
        PlayerDecisionView.board( sut.getCurrentGameBoard() );

        //Then
        Assert.assertTrue( result );
    }

    private char[][] fillFirstDiagonal() {
        char[][] firstDiagonalResults = new char[3][3];
        for (int i = 0; i < firstDiagonalResults.length; i++) {
            firstDiagonalResults[i][i] = CROSS_SIGN;
        }
        return firstDiagonalResults;
    }

    @Test
    public void SecondDiagonalWin() {
        //Given
        sut.setCurrentGameBoard( fillSecondDiagonal() );

        //When
        boolean result = sut.secondDiagonalWin();
        PlayerDecisionView.board( sut.getCurrentGameBoard() );

        //Then
        Assert.assertTrue( result );
    }

    private char[][] fillSecondDiagonal() {
        char[][] secondDiagonalResults = new char[3][3];

        for (int i = 0; i < secondDiagonalResults.length; i++) {
            int j = secondDiagonalResults.length - 1;
            secondDiagonalResults[i][j - i] = CROSS_SIGN;

        }
        return secondDiagonalResults;
    }

    @Test
    public void drawTest(){
        //Given
        sut.setCurrentGameBoard( fillTheTable() );

        //When
        PlayerDecisionView.board( fillTheTable() );
        boolean result = sut.draw();

        //Then
        Assert.assertTrue( result );
    }

    @Test
    public void boardIsFull() throws Exception {
        //given
        sut.setCurrentGameBoard( fillTheTable() );

        //when
        PlayerDecisionView.board( fillTheTable() );
        boolean result = sut.boardIsFull();

        //then

        Assert.assertTrue( result );

    }

    private char[][] fillTheTable() {
        char[][] table = new char[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = 'X';
            }
        }
        return table;
    }
}