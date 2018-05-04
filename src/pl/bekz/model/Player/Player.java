package pl.bekz.model.Player;

public interface Player {
    void makeMove();
    int pointTheRow();
    int pointTheColumn();
    boolean isCellEmpty(int row, int column);
}
