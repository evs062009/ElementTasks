package task3TrianglesSorting.validator;

import common.misc.Response;
import org.jetbrains.annotations.NotNull;
import task3TrianglesSorting.misc.ShapeData;
import task3TrianglesSorting.validator.validators.ISidesValidator;
import task3TrianglesSorting.validator.validators.IsEachSideLessSumOtherTwo;
import task3TrianglesSorting.validator.validators.IsSidesGreaterThanZero;
import task3TrianglesSorting.validator.validators.IsSidesNotLessThanThree;

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
            List<ISidesValidator> validators = getValidators();

            for (ISidesValidator validator : validators) {
                response = validator.isValid(data.getDoubles());
                if (!response.isValid()) {
                    break;
                }
            }
        }
        return response;
    }

    @NotNull
    private List<ISidesValidator> getValidators() {
        return Arrays.asList(
                new IsSidesNotLessThanThree(),
                new IsSidesGreaterThanZero(),
                new IsEachSideLessSumOtherTwo());
    }
}
