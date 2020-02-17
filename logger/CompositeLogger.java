package logger;

import java.io.IOException;
import java.util.List;

public class CompositeLogger implements Logger {
    protected List<Logger> loggers;

    public CompositeLogger(List<Logger> loggers) {
        this.loggers = loggers;
    }

    public void log(String message) throws IOException {
        for (Logger logger : loggers) {
            logger.log(message);
        }
    }

    public void log(String message, Throwable cause) throws IOException {
        for (Logger logger : loggers) {
            logger.log(message + " caused by " + cause);
        }
    }

}