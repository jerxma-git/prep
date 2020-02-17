package logger;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        try {
            Logger logger = new ConsoleLogger();
            Logger logger2 = new FileLogger(new File("out.txt"));
            Logger compLogger = new CompositeLogger(List.of(logger, logger2));
            compLogger.log("logger works");
        } catch(Exception e) {
            System.out.println("error occured: " + e.getMessage());
        }
    }
}