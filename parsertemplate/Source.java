package parsertemplate;

public interface Source {
    public char nextChar();
    public boolean hasNext();
    public /*changeme*/Exception error(String message);
}