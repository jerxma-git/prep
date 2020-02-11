package boardgametemplate;


public interface Board {
    public Position getPosition();
    public Result move(Move move);
}