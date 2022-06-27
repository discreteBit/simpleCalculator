import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String FIRST = "first";
        final String SECOND = "second";
        double x, y; // operands
        double result = 0; // output
        char operator = '#'; // operation -- allowed operations: +, -, *, /
        boolean isValid = true;
        boolean isDone = false;

        System.out.println("This is a simple calculator " +
                           "that performs an operation " +
                           "(+, -, *, /) on two operands.\n");

        // Get operands
        Scanner sc = new Scanner(System.in);

        do {
            x = getOperand(sc, FIRST);
            y = getOperand(sc, SECOND);

            // Get operator
            operator = getOperator(sc);

            // Do calculation
            switch (operator) {
                case '+':
                    result = x + y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '*':
                    result = x * y;
                    break;
                case '/':
                    if (y == 0) {
                        isValid = false;
                    } else {
                        result = x / y;
                        isValid = true; // reset isValid to true
                    }
                    break;
            }

            System.out.println("\nThe equation:\n" + x + " " + operator + " " + y +
                    (isValid ? " = " + result : " is invalid, division by zero is invalid"));

            System.out.println("\nEnter Y to input another calculation or any other key to quit: ");
            char cont = sc.next().charAt(0);
            isDone = !(cont == 'Y' || cont == 'y');
        } while(!isDone);

        System.out.println("Have a nice day!");
        System.exit(0);
    }

    private static double getOperand(Scanner sc, String position) {
        boolean isValid = false;
        double v = 0;

        System.out.println("Enter " + position + " operand:");
        while(!isValid) {
            try {
                v = sc.nextDouble();
                isValid = true;
            } catch (java.util.InputMismatchException e) {
                sc.next(); // consume invalid entry
                System.out.println("Please enter a valid operand:");
            }
        }
        return v;
    }

    private static char getOperator(Scanner sc) {
        boolean isValid = false;
        char o = '#';

        System.out.println("\nEnter operator (+, -, *, /):");
        while(!isValid) {
            try {
                o = sc.next().charAt(0);
                switch (o) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        isValid = true;
                        break;
                    default:
                        throw new InputMismatchException();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid operator (+, -, *, /):");
            }
        }
        return o;
    }
}