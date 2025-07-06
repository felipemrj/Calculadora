    package operations;

    public class Division extends Operator {
        public Division(double firstOperand, double secondOperand) {
            super(firstOperand, secondOperand);
        }

        @Override
        public double calculate() {
            return getFirstOperand() / getSecondOperand();
        }
    }
