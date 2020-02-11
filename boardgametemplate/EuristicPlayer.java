package boardgametemplate;



public class EuristicPlayer implements Player {
    
    public Move makeMove(Position position) {
        Move move;
        do {
            move = new Move();
            //TODO euristic strategy
        } while (!position.isValid(move));
        return move;
    }
}