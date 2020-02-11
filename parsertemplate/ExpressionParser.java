package parsertemplate;

import java.util.*;

public class ExpressionParser {
    private enum BinaryOperator {
        ADD, MUL
    } 

    private final Map<String, BinaryOperator> binOperators = Map.of(

    );

    public Expression parse(String expression) {

        return new AbstractBinaryOperation();
    }

}