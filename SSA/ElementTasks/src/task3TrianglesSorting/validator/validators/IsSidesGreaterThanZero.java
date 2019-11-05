package task3TrianglesSorting.validator.validators;

import common.misc.Response;

/*
 * Checks if all sides are greater than zero.
 */
public class IsSidesGreaterThanZero implements ISidesValidator {

    @Override
    public Response isValid(double[] sides) {
        for (double parameter : sides) {
            if (parameter <= 0) {
                return new Response(false,
                        String.format("Side have to be greater than zero: %s.", parameter));
            }
        }
        return new Response(true);
    }
}
