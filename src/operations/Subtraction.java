package operations;

public class Subtraction extends Operator {
    public Subtraction(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        return getFirstOperand() - getSecondOperand();
    }
}
