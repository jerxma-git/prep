package logger;

public class ConsoleLogger implements Logger {
    public ConsoleLogger() {

    }

    public void log(String message) {
        System.out.println(message);
    }
    public void log(String message, Throwable cause) {
        log(message + " caused by: " + cause);
    }
}