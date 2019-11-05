package task3TrianglesSorting.validator.validators;

import common.misc.Response;

/*
 * Checks if the array of sides contains three sides.
 */
public class IsSidesNotLessThanThree implements ISidesValidator {

    @Override
    public Response isValid(double[] sides) {
        if (sides == null || sides.length < 3) {
            return new Response(false, "Triangle must have 3 sides.");
        }
        return new Response(true);
    }
}
