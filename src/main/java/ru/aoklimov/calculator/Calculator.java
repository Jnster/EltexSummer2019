package ru.aoklimov.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n\nTo exit: anything besides 'number operator number'.");
        String expression = in.nextLine();
        while (expression.matches("[0-9]+[.]?[0-9]*[ ]?[-+/*][ ]?[0-9]+[.]?[0-9 ]*")) {
            List<String> digits = Arrays.asList(expression.split("[-+*/]"));
            List<String> operators = Arrays.asList(expression.split("[ ]?[0-9]+[.]?[0-9]*[ ]?"));
            Double result = null;

            digits = digits.stream()
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
            operators = operators.stream()
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            try {
                result = calculate(digits.get(0), digits.get(1), operators.get(0));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(result);
            expression = in.nextLine();
        }
    }

    private static Double calculate(String leftOp, String rightOp, String operator) {
        Double left = Double.valueOf(leftOp);
        Double right = Double.valueOf(rightOp);

        switch (operator) {
            case "+": {
                return left + right;
            }
            case "-": {
                return left - right;
            }
            case "*": {
                return left * right;
            }
            case "/": {
                return left / right;
            }
        }
        throw new RuntimeException("Unknowing operator");
    }
}
