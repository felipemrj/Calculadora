package main;

import operations.*;

public class Calculator {
    public static void main(String[] args) {
        UserInterface userUi = new UserInterface();

        while (true) {
            double firstNumberInput, secondNumberInput, operationResult;
            String userOperationInput;


            // Get/Validate FirstNum
            firstNumberInput = userUi.validateNumberInput();

            // Get Operation
            userOperationInput = userUi.validateOperationInput();

            // Get/Validate SecondNum
            secondNumberInput = userUi.validateNumberInput();

            Operator operator = null;
            switch (userOperationInput) {
                case "+":
                    operator = new Addition(firstNumberInput, secondNumberInput);
                    break;
                case "-":
                    operator = new Subtraction(firstNumberInput, secondNumberInput);
                    break;
                case "*":
                    operator = new Multiplication(firstNumberInput, secondNumberInput);
                    break;
                case "/":
                    operator = new Division(firstNumberInput, secondNumberInput);
                    break;
                case "%":
                    operator = new Percentage(firstNumberInput, secondNumberInput);
                    break;
                default:
                    System.out.println("Unknown");
                    break;
            }

            try {
                if (operator != null) {
                    operationResult = operator.calculate();
                    System.out.println(userUi.showResult(operationResult));
                } else {
                    System.out.println("Invalid operation.");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (!userUi.newCalculation()) {
                break;
            }
        }
    }
}
