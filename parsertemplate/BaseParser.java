package parsertemplate;

public class BaseParser {
    protected Source source;
    protected char curr;

    public BaseParser(Source source) {
        this.source = source;
    }

    public void nextChar() {
        curr = source.hasNext() ? source.nextChar() : '\0';
    }

    public boolean hasNext() {
        return curr != '\0';
    }

    public void expect(char ch) throws Exception {
        if (curr != ch) {
            throw error("Expected '" + ch + "', got '" + curr);
        }
    }

    public boolean test(char ch) {
        if (curr == ch) {
            nextChar();
            return true;
        }
        return false;
    }

    public void expect(String expectation) throws Exception {
        for (char ch : expectation.toCharArray()) {
            expect(ch);
        }
    }

    public Exception error(String message) {
        return source.error(message);
    }
}