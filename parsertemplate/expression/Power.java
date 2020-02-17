package expression;

public class Power extends AbstractUnOperation {
    public Power(CommonExpression expression) {
        super(expression);
    }

    @Override
    public String getSign() {
        return "pow2 ";
        // space?
    }

    @Override
    public int calculate(int val) {
        int r = 1;
        int a = 2;
        while (val != 0) {
            if (val % 2 == 1) {
                r *= a;
            }
            val /= 2;
            a *= a;
        }
        return r;
    }
}