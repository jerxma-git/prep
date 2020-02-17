package logger;

import java.io.*;

public class FileLogger extends BaseLogger {
    protected Writer writer;

    public FileLogger(File file) throws IOException {
        writer = new FileWriter(file);
    }

    @Override
    public void log(String message) throws IOException {
            writer.write(message);
    }

}