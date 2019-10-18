package utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtilities {

    public static double round(double number, int places)
            throws IllegalArgumentException {
        if (places < 0) {
            throw new IllegalArgumentException(
                    "Places can not be less than zero.");
        }

        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
