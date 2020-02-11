package rubik;

import java.util.*;

public class RubiksCube {
    
    public static final int SIZE = 3;
    private Plane[] sides;

    public static final Map<Colour, Character> COLOUR_TO_CHAR = new HashMap<>(Map.of(
        Colour.WHITE, 'W',
        Colour.RED, 'R',
        Colour.GREEN, 'G',
        Colour.ORANGE, 'O',
        Colour.YELLOW, 'Y',
        Colour.BLUE, 'B'
    )); 

    private static final Map<Side, Colour> INIT_COLOURS = new HashMap<>(Map.of(
        Side.TOP, Colour.WHITE,  // top
        Side.LEFT, Colour.RED,    // left 
        Side.FRONT, Colour.BLUE,   // front
        Side.RIGHT, Colour.ORANGE, // right
        Side.BACK, Colour.GREEN,  // back
        Side.BOT, Colour.YELLOW  // bot
    ));

    private static final Map<Integer, Side> INT_TO_SIDE = new HashMap<>(Map.of(
        0, Side.TOP,
        1, Side.LEFT,
        2, Side.FRONT,
        3, Side.RIGHT,
        4, Side.BACK,
        5, Side.BOT
    ));

    private static final Map<Side, Integer> SIDE_TO_INT = new HashMap<>(Map.of(
        Side.TOP, 0,
        Side.LEFT, 1,
        Side.FRONT, 2,
        Side.RIGHT, 3,
        Side.BACK, 4,
        Side.BOT, 5
    ));


    private static final Map<Side, List<Instruction>> ADJACENT_SIDES = new HashMap<>(Map.of( //ordered CCW
        Side.TOP, List.of(new Instruction(Side.BACK, true, 0), new Instruction(Side.LEFT, true, 0), new Instruction(Side.FRONT, true, 0), new Instruction(Side.RIGHT, true, 0)),
        Side.LEFT, List.of(new Instruction(Side.TOP, false, 0), new Instruction(Side.BACK, false, 0), new Instruction(Side.BOT, false, 0), new Instruction(Side.FRONT, false, 0)),
        Side.FRONT, List.of(new Instruction(Side.TOP, true, SIZE - 1), new Instruction(Side.LEFT, false, SIZE - 1), new Instruction(Side.BOT, true, 0), new Instruction(Side.RIGHT, false, 0)),
        Side.RIGHT, List.of(new Instruction(Side.TOP, false, SIZE - 1), new Instruction(Side.FRONT, false, SIZE - 1), new Instruction(Side.BOT, false, SIZE - 1), new Instruction(Side.BACK, false, SIZE - 1)),
        Side.BACK, List.of(new Instruction(Side.TOP, true, 0), new Instruction(Side.RIGHT, false, SIZE - 1), new Instruction(Side.BOT, true, SIZE - 1), new Instruction(Side.LEFT, false, 0)),
        Side.BOT, List.of(new Instruction(Side.BACK, true, SIZE - 1), new Instruction(Side.RIGHT, true, SIZE - 1), new Instruction(Side.FRONT, true, SIZE - 1), new Instruction(Side.LEFT, true, SIZE - 1))
    ));




    
    public RubiksCube() {
        sides = new Plane[6];
        for (int i = 0; i < 6; i++) {
            sides[i] = new Plane(INIT_COLOURS.get(INT_TO_SIDE.get(i)),  SIZE);
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        int currSide = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                str.append(' ');
            }
            str.append(sides[currSide].rowToString(i).reverse()).append('\n');
        }
        for (int i = 0; i < SIZE; i++) {
            for (currSide = 1; currSide < 4; currSide++) {
                str.append(sides[currSide].rowToString(i));
            }
            str.append(sides[4].rowToString(i).reverse());
            str.append('\n');
        }

        currSide = 5;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                str.append(' ');
            }
            str.append(sides[currSide].rowToString(i).reverse()).append('\n');
        }
        return str.toString();

    }


    public void printSide(int side) {
        System.out.println(sides[side].toString());
    }

    public void rotateSide(Side side, boolean clockWise) {
        sides[SIDE_TO_INT.get(side)].rotate(clockWise);
        List<Instruction> instructions;
        if (clockWise) {
            instructions = ADJACENT_SIDES.get(side);
        } else {
            instructions = revertedList(ADJACENT_SIDES.get(side));
        }
        Colour[] buffer;
        if (instructions.get(0).replaceRow) {
            buffer = Arrays.copyOf(sides[SIDE_TO_INT.get(instructions.get(0).side)].getRowCopy(instructions.get(0).index), SIZE);
        } else {
            buffer = Arrays.copyOf(sides[SIDE_TO_INT.get(instructions.get(0).side)].getColumnCopy(instructions.get(0).index), SIZE);
        }
        for (int i = 0; i < 4; i++) {
            int replacementSide = SIDE_TO_INT.get(instructions.get((i + 1) % 4).side);
            int replacementIndex = instructions.get((i + 1) % 4).index;
            int replacingIndex = instructions.get(i).index;
            int replacingSide = SIDE_TO_INT.get(instructions.get(i).side);

            if (instructions.get(i).replaceRow) {
                if (instructions.get((i + 1) % 4).replaceRow) {
                    sides[replacingSide].replaceRow(replacingIndex, i != 3 ? sides[replacementSide].getRowCopy(replacementIndex) : buffer);
                } else {
                    sides[replacingSide].replaceRow(replacingIndex, i != 3 ? sides[replacementSide].getColumnCopy(replacementIndex) : buffer);
                }
            } else {
                if (instructions.get((i + 1) % 4).replaceRow) {
                    sides[replacingSide].replaceColumn(replacingIndex, i != 3 ? sides[replacementSide].getRowCopy(replacementIndex) : buffer);
                } else {
                    sides[replacingSide].replaceColumn(replacingIndex, i != 3 ? sides[replacementSide].getColumnCopy(replacementIndex) : buffer);
                }
            }
        }
    }


    private List<Instruction> revertedList(List<Instruction> list) {
        List<Instruction> revertedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            revertedList.add(list.get(i));
        }
        return revertedList;
 
    }






}