package hajime.Lab01;

import java.util.Scanner;

public class SimpleEquationSolver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEQUATION SOLVER");
            System.out.println("1. Solve linear equation (ax + b = 0)");
            System.out.println("2. Solve system of 2 equations");
            System.out.println("3. Solve quadratic equation (ax^2 + bx + c = 0)");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    solveLinear(sc);
                    break;
                case 2:
                    solveSystem(sc);
                    break;
                case 3:
                    solveQuadratic(sc);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("NULL");
            }
        }
    }

    public static void solveLinear(Scanner sc) {
        System.out.println("\nLinear Equation ax + b = 0");
        System.out.println("Enter a and b:");

        double a = sc.nextDouble();
        double b = sc.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            System.out.println("x = " + (-b / a));
        }
    }

    public static void solveSystem(Scanner sc) {
        System.out.println("\nSystem of equations");
        System.out.println("Enter a11, a12, b1 for the first equation: a11x + a12 = b1: ");
        double a11 = sc.nextDouble();
        double a12 = sc.nextDouble();
        double b1 = sc.nextDouble();

        System.out.println("Enter a21, a22, b2 for the second equation: a21x + a22 = b2: ");
        double a21 = sc.nextDouble();
        double a22 = sc.nextDouble();
        double b2 = sc.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        }
    }

    public static void solveQuadratic(Scanner sc) {
        System.out.println("\nQuadratic Equation ax^2 + bx + c = 0");
        System.out.println("Enter a b c:");

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        if (a == 0) {
            System.out.println("This becomes a linear equation:");
            if (b == 0) {
                if (c == 0) System.out.println("Infinite solutions");
                else System.out.println("No solution");
            } else {
                System.out.println("x = " + (-c / b));
            }
            return;
        }

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            System.out.println("No real solution");
        } else if (delta == 0) {
            System.out.println("Double root x = " + (-b / (2 * a)));
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
    }
}
