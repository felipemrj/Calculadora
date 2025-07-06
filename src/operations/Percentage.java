package operations;

public class Percentage extends Operator {
    public Percentage(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        return getFirstOperand() / 100 * getSecondOperand();
    }

}
