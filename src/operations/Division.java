package operations;

public class Division extends Operator {
    public Division(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        if (getSecondOperand() == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return getFirstOperand() / getSecondOperand();
    }
}
