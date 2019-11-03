package task3TrianglesSorting.validator;

import common.misc.Response;
import task3TrianglesSorting.misc.ShapeData;
import task3TrianglesSorting.validator.validators.ISidesValidator;
import task3TrianglesSorting.validator.validators.IsEachSideLessSumOtherTwo;
import task3TrianglesSorting.validator.validators.IsSidesGreaterThanZero;

import java.util.Arrays;
import java.util.List;

public class TriangleValidator implements IShapeValidator {

    /**
     * Checks if the data is valid for creation a triangle using a list of validators.
     *
     * @param data the data for creating a triangle.
     * @return Response object which contains true and empty message, when data is valid for creation a triangle,
     * or false and warning message otherwise.
     */
    @Override
    public Response isValid(ShapeData data) {
        Response response = new Response(false, "input data == null");
        if (data != null) {
            List<ISidesValidator> validators = Arrays.asList(
                    new IsSidesNotLessThanThree(),
                    new IsSidesGreaterThanZero(),
                    new IsEachSideLessSumOtherTwo());

            for (ISidesValidator validator : validators) {
                response = validator.isValid(data.getDoubles());
                if (!response.isValid()) {
                    break;
                }
            }
        }
        return response;
    }

    private class IsSidesNotLessThanThree implements ISidesValidator {

        /**
         * Checks if the array of sides contains three sides.
         *
         * @param sides the array of sides
         * @return Response object which contains true and empty message, when the array has three elements,
         * or false and warning message otherwise.
         */
        @Override
        public Response isValid(double[] sides) {
            if (sides == null || sides.length < 3) {
                return new Response(false, "Triangle must have 3 sides.");
            }
            return new Response(true);
        }
    }
}
