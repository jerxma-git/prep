package logger;

import java.io.IOException;

public interface Logger {
    public void log(String message) throws IOException;
    public void log(String message, Throwable cause) throws IOException;
    public void log(String message, Format format) throws IOException;
}