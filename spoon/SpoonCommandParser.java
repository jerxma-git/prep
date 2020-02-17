package spoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SpoonCommandParser {
    protected static final Map<String, Command> commandCodes = Map.of(
        "1", Command.INC,
        "000", Command.DEC,
        "010", Command.NEXT,
        "011", Command.PREV,
        "00100", Command.STRT_CYC,
        "0011", Command.END_CYC,
        "0010110", Command.READ,
        "001010", Command.PRINT
    );
    protected static final int MAX_COMMAND_SIZE = 7;
    public static List<Command> parse(String commandsStr) throws UnknownCommandException {
        int pos = 0;
        List<Command> commands = new ArrayList<>();
        while (pos < commandsStr.length()) {
            while (pos < commandsStr.length() && Character.isWhitespace(commandsStr.charAt(pos))) {
                pos++;
            }
            StringBuilder parsedCommand = new StringBuilder();
            do {
                parsedCommand.append(commandsStr.charAt(pos++));
                if (parsedCommand.length() > MAX_COMMAND_SIZE) {
                    throw new UnknownCommandException(parsedCommand.toString());
                }
            } while (!commandCodes.containsKey(parsedCommand.toString()));
            commands.add(commandCodes.get(parsedCommand.toString()));
        }
        return commands;
    }
}