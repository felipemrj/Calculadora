package main;

import operations.*;

public class Calculator {
    public static void main(String[] args) {
    UserInterface userUi = new UserInterface();

    double firstNum, secondNum, operationResult;
    String operation;

    firstNum = userUi.numberInput();
    operation = userUi.operationInput();
    secondNum = userUi.numberInput();

    Operator operator = null;
    switch (operation) {
        case "+":
            operator = new Addition(firstNum, secondNum);
            break;
        case "-":
            operator = new Subtraction(firstNum, secondNum);
            break;
        case "*":
            operator = new Multiplication(firstNum, secondNum);
            break;
        case "/":
            operator = new Division(firstNum, secondNum);
            break;
        case "%":
            operator = new Percentage(firstNum, secondNum);
            break;
        default:
            System.out.println("Unknown");
            break;
    }
    operationResult = operator.calculate();
    System.out.println("Result: " + operationResult);

    }
}
