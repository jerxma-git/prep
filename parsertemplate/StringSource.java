package parsertemplate;

public class StringSource implements Source {
    private String str;
    private int pos;

    public StringSource(String str) {
        this.str = str;
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < str.length();
    }

    @Override
    public char nextChar() {
        return str.charAt(pos++);
    }

    @Override
    public Exception error(String message) {
        return new Exception("Error at " + pos + ": " + message);
    }
}