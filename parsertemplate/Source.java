package parsertemplate;

public interface Source {
    public boolean hasNext();
    public boolean hasPrev();
    public char nextChar();
    public char prevChar();
    public /*changeme*/Exception error(String message);
}