package operations;

public class Addition extends Operator {
    public Addition(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        return getFirstOperand() + getSecondOperand();
    }
}
