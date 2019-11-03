package task7NumericalSequence;

import utilities.IOUtilities;
import utilities.MathUtilities;

import java.math.RoundingMode;
import java.util.stream.IntStream;

class App {

    void execute(String[] args) {
        int n;
        int startNumber = 1;

        try {
            n = getN(args);
        } catch (IllegalArgumentException ex) {
            IOUtilities.println(String.format("Invalid parameter: %s.", ex.getMessage()));
            return;
        }
        int endNumber = getEndNumber(n);
        printSequence(getSequence(startNumber, endNumber));
    }

    private int getN(String[] args) throws IllegalArgumentException {
        if (args != null && args.length > 0) {
            int n = Integer.parseInt(args[0]);
            if (n > 0) {
                return n;
            }
        }
        throw new IllegalArgumentException("It needs 1 parameter: positive number");
    }

    private int getEndNumber(int n) {
        return (int) MathUtilities.round(Math.sqrt(n), 0, RoundingMode.CEILING);
    }

    private IntStream getSequence(int startNumber, int endNumber) {
        return IntStream.range(startNumber, endNumber);
    }

    private void printSequence(IntStream sequence) {
        sequence.forEach(n -> IOUtilities.print(String.format("%s, ", n)));
    }
}
