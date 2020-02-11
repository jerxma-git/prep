package rubik;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        RubiksCube cube = new RubiksCube();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(cube);
            String commands = scanner.nextLine();
            CommandParser parser = new CommandParser(cube, commands);
            parser.perform(false);
        }
        

    }
}