package boardgametemplate;


import java.util.*;

public class HumanPlayer implements Player {
    
    Scanner input;

    public HumanPlayer() {
        input = new Scanner(System.in);
    }

    public Move makeMove(Position position) {
        System.out.println(position.toString());
        Move move = new Move(); //TODO
        int[] moveValues = IntReader.readInts(2, (ints) -> true /*position.isValid(move = new Move(ints))*/ , "msg");

        return move;
    }
}