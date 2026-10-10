package Assignment1.Task1;

import java.util.Scanner;

public class Task1 {
     public static double sum(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }


    public static double division(double a, double b) {
        return a / b;
    }

    public static double square(double a) {
        return a * a;
    }

    public static double cube(double a) {
        return a * a * a;
    }

    public static double remainder(double a, double b) {
        return a % b;
    }

    public static double absolute(double a) {
        return Math.abs(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, result;
        int ch;

        do {
            System.out.println("\\n1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square");
            System.out.println("6. Cube");
            System.out.println("7. Remainder");
            System.out.println("8. Absolute");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 9.");
                sc.next();
                continue;
            }

            ch = sc.nextInt();

            if (ch == 9) {
                break;
            }

            if (ch < 1 || ch > 9) {
                System.out.println("Invalid choice");
                continue;
            }

            if (ch == 5 || ch == 6 || ch == 8) {
                System.out.print("Enter number: ");
                a = sc.nextDouble();

                switch (ch) {
                    case 5:
                        result = square(a);
                        break;
                    case 6:
                        result = cube(a);
                        break;
                    default:
                        result = absolute(a);
                }
            } else {
                System.out.print("Enter first number: ");
                a = sc.nextDouble();

                System.out.print("Enter second number: ");
                b = sc.nextDouble();

                if ((ch == 4 || ch == 7) && b == 0) {
                    System.out.println(ch == 4
                            ? "Cannot divide by zero"
                            : "Cannot find remainder with zero");
                    continue;
                }

                switch (ch) {
                    case 1:
                        result = sum(a, b);
                        break;
                    case 2:
                        result = subtraction(a, b);
                        break;
                    case 3:
                        result = multiplication(a, b);
                        break;
                    case 4:
                        result = division(a, b);
                        break;
                    default:
                        result = remainder(a, b);
                }
            }

            System.out.println("The result is = " + result);

        } while (true);

        sc.close();
    
}
}
