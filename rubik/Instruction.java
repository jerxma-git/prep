package rubik;

public class Instruction {
    public final Side side;
    public final boolean replaceRow;
    public final int index;

    public Instruction(Side side, boolean replaceRow, int index) {
        this.side = side;
        this.replaceRow = replaceRow;
        this.index = index;
    }

}