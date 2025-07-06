package operations;

public abstract class Operator {
    private double firstOperand, secondOperand;

    // Constructor
    public Operator(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    // Getters
    public double getFirstOperand() {
        return firstOperand;
    }
    public double getSecondOperand() {
        return  secondOperand;
    }

    // Methods
    public abstract double calculate();

}
