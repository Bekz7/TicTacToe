package pl.bekz.view;

public class PlayerDecisionView {

    public void startGame() {
        System.out.println( "Do you wanna play?" );
        choose();
    }

    public void rematch() {
        System.out.println( "Do you want play again? " );
        choose();
    }

    private void choose() {
        StringBuilder sb = new StringBuilder();
        sb.append( "[y]es \n" +
                "[n]o" );
        show( sb.toString() );
    }

    public void makeYourMove() {
        System.out.println( "Make Your move (row and column)" );
    }

    public static void board(char board[][]) {
        StringBuilder sb = new StringBuilder();
        sb.append(
                "/---|---|---\\\n" +
                        "| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |\n" +
                        "|-----------|\n" +
                        "| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |\n" +
                        "|-----------|\n" +
                        "| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |\n" +
                        "/---|---|---\\\n" );

        show( sb.toString() );
    }

    private static void show(String s) {
        System.out.println( s );
    }
}
