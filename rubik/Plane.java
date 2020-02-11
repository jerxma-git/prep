package rubik;

import java.util.*;

public class Plane {

    // private final Map<Colour, Character> COLOUR_TO_CHAR = new HashMap<>(Map.of(
    //     Colour.WHITE, 'W',
    //     Colour.RED, 'R',
    //     Colour.GREEN, 'G',
    //     Colour.ORANGE, 'O',
    //     Colour.YELLOW, 'Y',
    //     Colour.BLUE, 'B'
    // ));

    private Colour[][] cells;
    private final int SIZE;

    public Plane(Colour colour, int size) {
        SIZE = size;
        cells = new Colour[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = colour;
            }
        }
    }

    public Colour get(int row, int col) {
        return cells[row][col];
    }

    public StringBuilder rowToString(int row) {
        StringBuilder str = new StringBuilder();
        for (int col = 0; col < SIZE; col++) {
            str.append(RubiksCube.COLOUR_TO_CHAR.get(cells[row][col]));
        }
        return str;
    }

    public void set(int row, int col, Colour colour) {
        cells[row][col] = colour;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            str.append(rowToString(row))
                .append('\n');
        }
        return str.toString();
    } 

    public void rotate(boolean clockWise) {
        Colour[][] cellsCopy = new Colour[SIZE][SIZE];
        
        for (int row = 0; row < SIZE; row++) {
            cellsCopy[row] = Arrays.copyOf(cells[row], SIZE);
        }

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = !clockWise ? cellsCopy[col][SIZE - 1 - row] : cellsCopy[SIZE - 1 - col][row];
            }
        }
    }

    public Colour[] getRowCopy(int row) {
        return Arrays.copyOf(cells[row], SIZE);
    }

    public Colour[] getColumnCopy(int col) {
        Colour[] copy = new Colour[SIZE];
        for (int i = 0; i < SIZE; i++) {
            copy[i] = cells[i][col]; 
        }
        return copy;
    }

    public void replaceRow(int row, Colour[] replacement) {
        cells[row] = Arrays.copyOf(replacement, SIZE);
    }

    public void replaceColumn(int col, Colour[] replacement) {
        for (int i = 0; i < SIZE; i++) {
            cells[i][col] = replacement[i];
        }
    }

    

}