package task9Exponentiation;

import utilities.IOUtilities;
import utilities.MathUtilities;

public class App {

    public void execute(String[] args) {
        int number = 0;
        int exp = 0;
        String invalid = "Invalid arguments: ";

        if (args != null && args.length > 1) {
            try {
                number = Integer.parseInt(args[0]);
                exp = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                IOUtilities.println(invalid + e.getMessage());
            }
            int result = MathUtilities.pow(number, exp);
            IOUtilities.println(String.format("%s pow %s = %s", number, exp, result));
        } else {
            IOUtilities.println(invalid);
        }
    }
}
