package main;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

import operations.*;

public class Calculator {

    private static double firstOperand = 0;
    private static double secondOperand = 0;
    private static String operator = "";
    private static boolean startNewInput = true;
    private static JTextField display;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        // Window Config
        JFrame calculatorWindow = new JFrame("Calculator");
        calculatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorWindow.setSize(355, 410);
        calculatorWindow.setLocationRelativeTo(null);
        calculatorWindow.setResizable(false);

        // Panel Config
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(220, 220, 220));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Layout Config
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        // Display Config
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setBackground(new Color(230, 230, 230));
        display.setForeground(Color.BLACK);
        display.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        mainPanel.add(display, gbc);

        // Buttons are implemented in the same order as they appear in the calculator interface
        JButton clearButton = new JButton("C");
        setupButton(clearButton, gbc, mainPanel, 3, 0);
        clearButton.addActionListener(e -> resetCalculator());

        JButton sevenButton = new JButton("7");
        setupButton(sevenButton, gbc, mainPanel, 0, 1);
        sevenButton.addActionListener(e -> digitPressed("7"));

        JButton eightButton = new JButton("8");
        setupButton(eightButton, gbc, mainPanel, 1, 1);
        eightButton.addActionListener(e -> digitPressed("8"));

        JButton nineButton = new JButton("9");
        setupButton(nineButton, gbc, mainPanel, 2, 1);
        nineButton.addActionListener(e -> digitPressed("9"));

        JButton divisionButton = new JButton("/");
        setupButton(divisionButton, gbc, mainPanel, 3, 1);
        divisionButton.addActionListener(e -> operatorPressed("/"));

        JButton fourButton = new JButton("4");
        setupButton(fourButton, gbc, mainPanel, 0, 2);
        fourButton.addActionListener(e -> digitPressed("4"));

        JButton fiveButton = new JButton("5");
        setupButton(fiveButton, gbc, mainPanel, 1, 2);
        fiveButton.addActionListener(e -> digitPressed("5"));

        JButton sixButton = new JButton("6");
        setupButton(sixButton, gbc, mainPanel, 2, 2);
        sixButton.addActionListener(e -> digitPressed("6"));

        JButton multiplicationButton = new JButton("*");
        setupButton(multiplicationButton, gbc, mainPanel, 3, 2);
        multiplicationButton.addActionListener(e -> operatorPressed("*"));

        JButton oneButton = new JButton("1");
        setupButton(oneButton, gbc, mainPanel, 0, 3);
        oneButton.addActionListener(e -> digitPressed("1"));

        JButton twoButton = new JButton("2");
        setupButton(twoButton, gbc, mainPanel, 1, 3);
        twoButton.addActionListener(e -> digitPressed("2"));

        JButton threeButton = new JButton("3");
        setupButton(threeButton, gbc, mainPanel, 2, 3);
        threeButton.addActionListener(e -> digitPressed("3"));

        JButton subtractionButton = new JButton("-");
        setupButton(subtractionButton, gbc, mainPanel, 3, 3);
        subtractionButton.addActionListener(e -> operatorPressed("-"));

        JButton zeroButton = new JButton("0");
        setupButton(zeroButton, gbc, mainPanel, 0, 4);
        zeroButton.addActionListener(e -> digitPressed("0"));

        JButton dotButton = new JButton(".");
        setupButton(dotButton, gbc, mainPanel, 1, 4);
        dotButton.addActionListener(e -> {
            if (startNewInput) {
                display.setText("0.");
                startNewInput = false;
            } else if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        });

        JButton equalButton = new JButton("=");
        setupButton(equalButton, gbc, mainPanel, 2, 4);
        equalButton.addActionListener(e -> {
            try {
                secondOperand = Double.parseDouble(display.getText());
                display.setText(formatResult(calculateResult()));
            } catch (ArithmeticException ex) {
                display.setText("Error");
            }
            startNewInput = true;
        });

        JButton additionButton = new JButton("+");
        setupButton(additionButton, gbc, mainPanel, 3, 4);
        additionButton.addActionListener(e -> operatorPressed("+"));

        calculatorWindow.setContentPane(mainPanel);
        calculatorWindow.setVisible(true);
    }

    private static void setupButton(JButton button, GridBagConstraints gbc, JPanel panel, int gridx, int gridy) {
        button.setFont(new Font("Arial", Font.BOLD, 22));
        button.setBackground(new Color(230, 230, 230));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(button, gbc);
    }

    private static void digitPressed(String digit) {
        if (display.getText().equals("0") || startNewInput) {
            display.setText(digit);
            startNewInput = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    private static void operatorPressed(String op) {
        firstOperand = Double.parseDouble(display.getText());
        operator = op;
        startNewInput = true;
    }

    private static void resetCalculator() {
        display.setText("0");
        firstOperand = 0;
        secondOperand = 0;
        operator = "";
        startNewInput = true;
    }

    private static double calculateResult() {
        switch (operator) {
            case "+": return new Addition(firstOperand, secondOperand).calculate();
            case "-": return new Subtraction(firstOperand, secondOperand).calculate();
            case "*": return new Multiplication(firstOperand, secondOperand).calculate();
            case "/":
                if (secondOperand == 0) throw new ArithmeticException("Division by zero");
                return new Division(firstOperand, secondOperand).calculate();
        }
        return 0;
    }

    private static String formatResult(double result) {
        DecimalFormat formatResult = new DecimalFormat("#.###");
        return formatResult.format(result);
    }

}