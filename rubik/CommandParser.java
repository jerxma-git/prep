package rubik;

import java.io.*;
import java.util.*;



public class CommandParser {

    private static Map<Character, Side> DECIPHER = new HashMap<>(Map.of(
        'D', Side.BOT,
        'U', Side.TOP,
        'L', Side.LEFT,
        'R', Side.RIGHT,
        'B', Side.BACK,
        'F', Side.FRONT
    ));
    private RubiksCube cube;
    private String commands;
    private int pos;
    public CommandParser(RubiksCube cube, String commands) {
        this.cube = cube;
        this.commands = commands;
        pos = 0;
    }

    public void perform(boolean log) {
        System.out.println("performing:");
        while (nextRotation()) {
            if (log) {
                System.out.println(cube.toString());
            }
        }
    }

    public boolean nextRotation() {
        if (pos >= commands.length()) {
            return false;   
        } 
        Side side = DECIPHER.get(commands.charAt(pos++));
        boolean clockWise = true;
        if (pos < commands.length() && isCCWSymbol(commands.charAt(pos))) {
            clockWise = false;
            pos++;
        }
        cube.rotateSide(side, clockWise);
        return true;
    }

    private boolean isCCWSymbol(Character ch) {
        return ch == '\'';  
    }
}