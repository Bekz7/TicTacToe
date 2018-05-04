package pl.bekz.view;

public class MenuView {

    public void showBanner() {
        StringBuilder sb = new StringBuilder();
        sb.append( " ____o__ __o____    o               ____o__ __o____                          ____o__ __o____                           \n" +
                "  /   \\   /   \\   _<|>_              /   \\   /   \\                            /   \\   /   \\                            \n" +
                "       \\o/                                \\o/                                      \\o/                                 \n" +
                "        |           o        __o__         |            o__ __o/      __o__         |           o__ __o      o__  __o  \n" +
                "       < >         <|>      />  \\         < >          /v     |      />  \\         < >         /v     v\\    /v      |> \n" +
                "        |          / \\    o/               |          />     / \\   o/               |         />       <\\  />      //  \n" +
                "        o          \\o/   <|                o          \\      \\o/  <|                o         \\         /  \\o    o/    \n" +
                "       <|           |     \\\\              <|           o      |    \\\\              <|          o       o    v\\  /v __o \n" +
                "       / \\         / \\     _\\o__</        / \\          <\\__  / \\    _\\o__</        / \\         <\\__ __/>     <\\/> __/> " );

        show( sb.toString() );
    }

    public void introduction() {
        gameInformation();
        startGame();
    }

    private void gameInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append( "You are: X" );
        sb.append( "Computer is: Y" );
        sb.append( "You can quit the game any time by pressing [q]" );
        show( sb.toString() );
    }

    private void startGame() {
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

    public void results() {
        System.out.println( "Your score is: " );
        System.out.println( "Computer score is: " );
    }

    public void gameIsFinished() {
        System.out.println( "Game is finished. " );
        rematch();
    }

    private static void show(String s) {
        System.out.println( s );
    }

}
