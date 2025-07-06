package main;
import java.util.Scanner;
public class UserInterface {
    Scanner read = new Scanner(System.in);

    public String operationInput() {
        String operation;
        System.out.println("Choose an operation (+, -, *, /, %)");
        operation = read.nextLine();
        return operation;
    }

    public double numberInput() {
        double number;
        System.out.println("Type a number: ");
        number = read.nextDouble();
        read.nextLine();
        return number;
    }

}
