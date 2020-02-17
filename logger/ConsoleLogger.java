package logger;

public class ConsoleLogger extends BaseLogger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
    
}