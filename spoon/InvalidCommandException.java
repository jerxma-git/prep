package spoon;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String msg) {
        super("Invalid command: " + msg);
    }
}