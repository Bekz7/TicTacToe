package pl.bekz.model.Board;


public class Board {
    public static char[][] currentGameBoard;
    private final int ROWS = 3;
    private final int COLS = 3;

    public Board() {
        currentGameBoard = new char[ROWS][COLS];
        init();
    }

    private void init() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                currentGameBoard[row][col] = '0';
            }
        }
    }

}
