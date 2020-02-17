package spoon;

public class MemoryLimitExceededException extends RuntimeException {
    public MemoryLimitExceededException(String msg) {
        super("Memory limt exceeded:" + msg);
    }
}