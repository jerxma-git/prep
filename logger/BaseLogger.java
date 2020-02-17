package logger;

import java.io.IOException;

public abstract class BaseLogger implements Logger {
    
    public abstract void log(String message) throws IOException;
    public void log(String message, Throwable cause) throws IOException {
        log(message + " caused by " + cause);
    }

    

}