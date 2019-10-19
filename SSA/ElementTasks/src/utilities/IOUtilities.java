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
}
