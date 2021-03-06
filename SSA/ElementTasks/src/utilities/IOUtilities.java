package utilities;

import java.util.Scanner;

public class IOUtilities {

    private static Scanner sc;

    private IOUtilities() {
    }

    public static double inputDouble(String message) throws NumberFormatException {
        sc = new Scanner(System.in);
        print(message);
        String input = sc.next().trim();
        return Double.parseDouble(input);
    }

    public static void printlnWithEmptyLine(String str) {
        System.out.println(str);
        System.out.println();
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static boolean isContinue() {
        final String Y = "y";
        final String YES = "yes";
        sc = new Scanner(System.in);

        IOUtilities.print(String.format(
                "For adding another triangle interfaces '%s' or '%s'. "
                        .concat("For finish interfaces another symbol: "), Y, YES));
        String input = sc.next().trim();
        return Y.equalsIgnoreCase(input) || YES.equalsIgnoreCase(input);
    }

    public static String inputString(String title) {
        sc = new Scanner(System.in);
        if (title != null && !title.isEmpty()) {
            print(title);
        }
        return sc.nextLine();
    }
}
