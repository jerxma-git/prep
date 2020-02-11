package boardgametemplate;


import java.util.*;

public class Game {
    private List<Player> players;
    private boolean log;
    public Game(List<Player> players, boolean log) {
        this.players = players;
        this.log = log;
    }

    public int play(Board board) {
        int turn = 0;
        while (true) {
            Result result = board.move(players.get(turn).makeMove(board.getPosition()));
            switch (result) {
                case WIN:
                    log("Player" + (turn + 1) + " wins!");
                return turn + 1;
                case LOSE:
                    log("Player" + (turn + 1) + " loses!");
                return -(turn + 1);
                case DRAW:
                    log("Draw!");
                    return 0;
                case UNKNOWN:
                    turn = (turn + 1) % players.size();
                    break;
                default:
                    throw new IllegalStateException();
            }
            
        }
    }

    private void log(String msg) {
        if (log) {
            System.out.println(msg);
        }
    }
}