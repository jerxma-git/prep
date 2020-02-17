package logger;

import java.io.*;

public class FileLogger implements Logger {
    protected Writer writer;

    public FileLogger(File file) throws IOException {
        writer = new FileWriter(file);
    }

    public void log(String message) throws IOException {
            writer.write(message);
    }

    public void log(String message, Throwable cause) throws IOException {
        log(message + " caused by : " + cause);
    }
}