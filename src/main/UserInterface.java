package main;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;
public class UserInterface {
    Scanner read = new Scanner(System.in);

    public boolean newCalculation() {
        System.out.println("Continue? (1. Yes / 2. No)");
        String answer = read.nextLine();
        if (answer.equals("2")) {
            return false;
        } else {
            return true;
        }
    }

    public String validateOperationInput() {
        while (true) {
            System.out.println("Choose an operation: ");
            System.out.println(" + : Addition");
            System.out.println(" - : Subtraction");
            System.out.println(" * : Multiplication");
            System.out.println(" / : Division");
            System.out.println(" % : Percentage (X% of Y)");
            String userInput = read.nextLine();
            if (Objects.equals(userInput, "+") || Objects.equals(userInput, "-") || Objects.equals(userInput, "*") ||
                Objects.equals(userInput, "/") || Objects.equals(userInput, "%")) {
                return userInput;
            } else {
                System.out.println("Invalid operation, please try again.");
            }
        }
    }

    public double validateNumberInput() {
        while (true) {
            System.out.println("Type a number: ");
            String userInput = read.nextLine();
            try {
                return Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, please try again.");
            }
        }
    }

    public String showResult(double result) {
        DecimalFormat formatResult = new DecimalFormat("#.##");
        return ("Result: " + formatResult.format(result));
    }


}
