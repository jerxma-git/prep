package logger;

import java.io.IOException;
import java.util.List;

public class CompositeLogger extends BaseLogger {
    protected List<Logger> loggers;

    public CompositeLogger(List<Logger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void log(String message) throws IOException {
        for (Logger logger : loggers) {
            logger.log(message);
        }
    }

    @Override
    public void log(String message, Throwable cause) throws IOException {
        for (Logger logger : loggers) {
            logger.log(message + " caused by " + cause);
        }
    }



}