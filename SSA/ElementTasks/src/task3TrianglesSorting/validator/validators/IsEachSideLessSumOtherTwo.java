package task3TrianglesSorting.validator.validators;

import common.misc.Response;

/*
 * Checks if a length of each side is Less than a sum of two other.
 */
public class IsEachSideLessSumOtherTwo implements ISidesValidator {

    @Override
    public Response isValid(double[] sides) {
        double sum = 0;
        for (double side : sides) {
            sum += side;
        }
        for (double side : sides) {
            double sumOtherTwo = sum - side;
            if (side >= sumOtherTwo) {
                return new Response(false,
                        String.format("Side %s can not be greater than sum of other two sides.", side));
            }
        }
        return new Response(true);
    }
}
