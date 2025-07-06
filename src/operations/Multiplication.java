package operations;

public class Multiplication extends Operator {

    public Multiplication(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        return getFirstOperand() * getSecondOperand();
    }
}
