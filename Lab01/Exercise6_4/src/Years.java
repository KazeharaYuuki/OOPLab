import java.util.Scanner;

public class Years {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month;
        int year;

        while (true) {
            System.out.print("Enter month (name, short, or number): ");
            String input = sc.nextLine().toLowerCase();

            month = getMonth(input);

            if (month != 0) break;
            System.out.println("Invalid month! Try again.");
        }

        while (true) {
            System.out.print("Enter year (non-negative): ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year >= 0) break;
            } else {
                sc.next();
            }
            System.out.println("Invalid year! Try again.");
        }

        boolean isLeap = isLeapYear(year);

        int days = getDays(month, isLeap);

        System.out.println("Number of days: " + days);

        sc.close();
    }

    public static int getMonth(String input) {
        return switch (input) {
            case "1", "jan", "january" -> 1;
            case "2", "feb", "february" -> 2;
            case "3", "mar", "march" -> 3;
            case "4", "apr", "april" -> 4;
            case "5", "may" -> 5;
            case "6", "jun", "june" -> 6;
            case "7", "jul", "july" -> 7;
            case "8", "aug", "august" -> 8;
            case "9", "sep", "sept", "september" -> 9;
            case "10", "oct", "october" -> 10;
            case "11", "nov", "november" -> 11;
            case "12", "dec", "december" -> 12;
            default -> 0;
        };
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDays(int month, boolean isLeap) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeap ? 29 : 28;
            default -> 0;
        };
    }
}