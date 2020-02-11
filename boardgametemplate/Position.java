package boardgametemplate;


public interface Position {
    public int getM();
    public int getN();
    public String toString();
    public boolean isValid(Move move);
}