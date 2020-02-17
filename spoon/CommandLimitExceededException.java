package spoon;

public class CommandLimitExceededException extends RuntimeException {
    public CommandLimitExceededException(String msg) {
        super("Command limit exceeded: " + msg);
    }
}