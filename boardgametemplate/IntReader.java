package boardgametemplate;


import java.util.function.Function;
import java.util.*;

public class IntReader {

    public static int[] readInts(int number, Function<int[], Boolean> rule, String msg) {
        System.out.println("Please, input " + number + " integer numbers ");
        if (!msg.isEmpty()) {
            System.out.println(msg);
        }
        int[] ints = new int[number];
        Scanner input = new Scanner(System.in);
        outer: while (true) {
            for (int i = 0; i < number; i++) {
                if (!input.hasNextInt()) {
                    for (int j = i; j < number; j++) {
                        input.next();
                    }
                    System.out.println("Invalid input: non-integer tokens encountered. Please, input " + number + " integer numbers");
                    if (!msg.isEmpty()) {
                        System.out.println(msg);
                    }
                    continue outer;
                } else {
                    ints[i] = input.nextInt();
                }
            }
            if (rule.apply(ints)) {
                input.close();
                return ints;
            } else {
                System.out.println("Invalid move. Please, input a correct move:");
            }
        }


    }
}