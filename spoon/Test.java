package spoon;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("not enough arguments");
        } else {
            List<Command> commands = SpoonCommandParser.parse(args[0]);
            String input = args.length < 2 ? "" : args[1];
            Interpreter interpreter = new Interpreter(1000, 1000, commands, input);
            interpreter.run();
        }
        
    }
}