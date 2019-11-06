package utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MathUtilities {

    private MathUtilities() {
    }

    public static double round(double number, int places, RoundingMode mode)
            throws IllegalArgumentException {
        if (places < 0) {
            throw new IllegalArgumentException(
                    "Places can not be less than zero.");
        }

        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        bigDecimal = bigDecimal.setScale(places, mode);
        return bigDecimal.doubleValue();
    }

    public static int pow(int number, int exp) {
        int result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= number;
            }
            number *= number;
            exp /= 2;
        }
        return result;
    }

    public static List<Long> fibonacchiSequence(long threshold) {
        List<Long> fibonacchi = new ArrayList<>();
        fibonacchi.add(1L);
        long x = 1;
        long y = 1;
        long f = 1;

        while (f < threshold) {
            fibonacchi.add(f);
            f = x + y;
            x = y;
            y = f;
        }
        return fibonacchi;
    }
}
