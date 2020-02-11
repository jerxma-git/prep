package boardgametemplate;


import java.util.*;

public class RandomPlayer implements Player {
    Random random;
    public RandomPlayer(Random random) {
        this.random = random;
    }

    public RandomPlayer() {
        this(new Random());
    }

    public Move makeMove(Position position) {
        Move move;
        do {
            move = new Move();
            //TODO
        } while (!position.isValid(move));
        return move;
    }
}