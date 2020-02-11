package boardgametemplate;


public class ProxyPosition implements Position {
    private Position position;

    public ProxyPosition(Position posititon) {
        this.position = position;
    }

    public int getM() {
        return position.getM();
    }

    public int getN() {
        return position.getN();
    }

    public String toString() {
        return position.toString();
    }

    public boolean isValid(Move move) {
        return position.isValid(move);
    }


}