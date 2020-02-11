package boardgametemplate;


import java.util.*;

public class SmthBoard implements Board, Position {

    private static final Map<Cell, Character> CELL_TO_CHAR = new HashMap<>(Map.of(

    )); 
    private int m; // height
    private int n; // width
    private Cell[][] cells;

    public SmthBoard(int m, int n) {
        this.m = m;
        this.n = n;
        cells = new Cell[m][n];
    }


    public boolean isValid(Move move) {
        // TODO
        return true;
    }

    public Result move(Move move) {
        // TODO
        return Result.UNKNOWN;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public Position getPosition() {
        return new ProxyPosition(this);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append('#');
        for (int i = 0; i < n; i++) {
            str.append(i);
        }
        str.append('\n');
        for (int row = 0; row < m; row++) {
            str.append(row);
            for (int col = 0; col < n; col++) {
                str.append(CELL_TO_CHAR.get(cells[row][col]));
            }
            str.append('\n');
        }
        return str.toString();
    }

}