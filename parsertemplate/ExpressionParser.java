package parsertemplate;

import java.util.*;

public class ExpressionParser {
    private enum Token {
        ADD, MUL, NEG, VAR, CONST, OPEN_BRACKET, CLOSE_BRACKET
    }

    private final Map<String, Token> binOperators = Map.of(
        "*", Token.MUL,
        "+", Token.ADD
    );

    private final Map<String, Token> unOperators = Map.of(
        "-", Token.NEG
    );

    private final Map<Token, Integer> priorities = Map.of(

    );

    final int highestPriority = 0;
    final int lowestPriority;

    public ExpressionParser() {
        
        
    }

    private Map<String, String> getPrefixesMap(Map<String, Token> map) {
        Map<String, String> prefMap = new HashMap<>();
        for (Map.Entry<String, Token> entry : map.entrySet()) {
            String operator = entry.getKey();
            for (int i = 1; i < operator.length(); i++) {
                prefMap.put(operator.substring(0, i), operator);
            }
        }
        return prefMap;
    } 


    public Expression parse(String expression) {

        Expression expression = getExpression(topPriority);
        return new AbstractBinaryOperation();
    }



}