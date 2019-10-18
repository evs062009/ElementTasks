package utilities;

import java.util.Scanner;

public class InputUtilities {

    public static double input() throws NumberFormatException {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().trim();
        return Double.parseDouble(input);
    }
}
