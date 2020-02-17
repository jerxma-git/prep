package spoon;

public class UnknownCommandException extends Exception {
    public UnknownCommandException(String msg) {
        super("Unknown command: " + msg);
    }
}