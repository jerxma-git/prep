package expression;

public class Logarithm extends AbstractUnOperation {
    
    public Logarithm(CommonExpression expression) {
        super(expression);
    }

    @Override
    public String getSign() {
        return "log2 ";
        // space?
    }

    @Override
    public int calculate(int val) {
        int res = 0;
        while (val > 1) {
            val /= 2;
            res++;
        }
        return res;
    }

    

}