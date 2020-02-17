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
            compLogger.log("17.02.2020", Format.DATE);
            compLogger.log("02.13.2020", Format.DATE);
        } catch(Exception e) {
            System.out.println("writing error occured: " + e.getMessage());
        }
    }
}