package Task8FibonacciSequence;

import org.jetbrains.annotations.Nullable;
import utilities.IOUtilities;
import utilities.MathUtilities;

import java.util.List;
import java.util.stream.Collectors;

public class App {

    public void execute(String[] args) {
        if (args != null && args.length > 0) {
            List<Long> fibonacchi = null;

            if (args.length == 1) {
                fibonacchi = getFibonacchiSequence(args[0]);
            } else if (args.length == 2) {
                fibonacchi = getFibonacchiSequence(args[0], args[1]);
            }

            if (fibonacchi != null && !fibonacchi.isEmpty()) {
                IOUtilities.println(fibonacchi.toString());
                return;
            }
        }
        IOUtilities.println("Invalid arguments.");
    }

    @Nullable
    private List<Long> getFibonacchiSequence(String numberLengthStr) {
        int numberLength;
        try {
            numberLength = Integer.parseInt(numberLengthStr);
        } catch (NumberFormatException e) {
            return null;
        }
        return MathUtilities.fibonacchiSequence(getThreshold(numberLength));
    }

    @Nullable
    private List<Long> getFibonacchiSequence(String bottomStr, String topStr) {
        long bottomThreshold;
        long topThreshold;

        try {
            bottomThreshold = Long.parseLong(bottomStr);
            topThreshold = Long.parseLong(topStr);
        } catch (NumberFormatException e) {
            return null;
        }
        if (bottomThreshold > topThreshold) {
            return null;
        }

        List<Long> fibonacchi = MathUtilities.fibonacchiSequence(topThreshold);
        return fibonacchi.stream().filter(e -> e >= bottomThreshold).collect(Collectors.toList());
    }

    private long getThreshold(int numberLength) {
        int base = 9;
        long number = 0;
        for (int i = 0; i < numberLength; i++) {
            number = number + base * Math.round(Math.pow(10, i));
        }
        return number;
    }
}