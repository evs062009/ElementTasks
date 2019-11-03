package utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtilities {

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
}
