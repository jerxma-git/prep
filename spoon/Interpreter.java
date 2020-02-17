package spoon;

import java.io.IOException;
import java.util.*;



public class Interpreter {
    protected int[] data;
    protected int dataPos;
    protected int commandNum;
    protected final int commandLimit;
    protected Stack<Integer> cycleStarts;
    protected List<Command> commands;
    protected int commandsPos;
    protected Scanner scanner;
    protected int memoryLimit;
    public Interpreter(int memoryLimit, int commandLimit, List<Command> commands, String input) {
        this.data = new int[memoryLimit]; //0s guaranteed
        this.dataPos = 0;
        this.commands = commands;
        this.commandsPos = 0;
        this.commandLimit = commandLimit;
        this.commandNum = 0;
        this.scanner = new Scanner(input);
        this.cycleStarts = new Stack<>();
        this.memoryLimit = memoryLimit;
    }

    protected boolean hasNextCommand() {
        return commandsPos < commands.size();
    }

    protected void run() {
        while (hasNextCommand()) {
            nextCommand();
        }
    }


    protected void nextCommand() {
        if (commandNum >= commandLimit) {
            throw new CommandLimitExceededException("Current command limit is " + commandLimit);
        }
        switch (commands.get(commandsPos)) {
        case INC:
            inc();
            break;
        case DEC:
            dec();
            break;
        case NEXT:
            next();
            break;
        case PREV:
            prev();
            break;
        case STRT_CYC:
            startCycle();
            break;
        case READ:
            read();
            break;
        case PRINT:
            print();
            break;
        case END_CYC:
            endCycle();
            break;
        default:
            //TODO exception?
            break;
        }
        commandNum++;
        commandsPos++;
    }

    protected void inc() {
        data[dataPos]++;
    }

    protected void dec() {
        data[dataPos]--;
    }

    protected void next() throws MemoryLimitExceededException {
        if (dataPos == data.length) {
            throw new MemoryLimitExceededException("current memory limit is " + memoryLimit);
        }
        dataPos++;
    }

    protected void prev() {
        if (dataPos == 0) {
            throw new InvalidCommandException(Command.PREV + " no previous cell");
        }
        dataPos--;
    }

    protected void startCycle() {
        cycleStarts.add(commandsPos); 
    }

    protected void endCycle() {
        if (data[dataPos] == 0) {
            if (cycleStarts.size() == 0) {
                throw new InvalidCommandException("No matching cycle start");
            }
            cycleStarts.pop();
        } else {
            commandsPos = cycleStarts.peek();
        }
    }

    protected void read() {
        if (!scanner.hasNextInt()) {
            //TODO exception?
        }
        data[dataPos] = scanner.nextInt();
    }

    protected void print() {
        System.out.print((char) data[dataPos]);
    }






}