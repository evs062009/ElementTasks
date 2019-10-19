package utilities;

import java.util.Scanner;

public class IOUtilities {

    public static double inputDouble() throws NumberFormatException {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().trim();
        return Double.parseDouble(input);
    }

    public static void printlnWithEmptyLine(String str) {
        System.out.println(str);
        System.out.println();
    }

    public static void print(String str){
        System.out.print(str);
    }

    public static void println(String str){
        System.out.println(str);
    }

    public static boolean isContinue() {
        final String Y = "y";
        final String YES = "yes";
        Scanner sc = new Scanner(System.in);

        IOUtilities.print(String.format(
                "For adding another triangle input '%s' or '%s'. "
                        .concat("For finish input another symbol: "), Y, YES));
        String input = sc.next().trim();
        return Y.equalsIgnoreCase(input) || YES.equalsIgnoreCase(input);
    }
}
