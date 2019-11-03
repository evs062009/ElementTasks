package task3TrianglesSorting.validator;

import common.interfaces.IValidator;
import task3TrianglesSorting.misc.ShapeData;
import task3TrianglesSorting.validator.validators.ISidesValidator;
import task3TrianglesSorting.validator.validators.IsEachSideLessSumOtherTwo;
import task3TrianglesSorting.validator.validators.IsSidesGreaterThanZero;

import java.util.Arrays;
import java.util.List;

public class TriangleValidator implements IValidator {

    @Override
    public Responce isValid(ShapeData data) {
        Responce responce = new Responce(false, "input data == null");
        if (data != null) {
            List<ISidesValidator> validators = Arrays.asList(
                    new IsSidesNotLessThanThree(),
                    new IsSidesGreaterThanZero(),
                    new IsEachSideLessSumOtherTwo());

            for (ISidesValidator validator : validators) {
                responce = validator.isValid(data.getDoubles());
                if (!responce.isValid()) {
                    break;
                }
            }
        }
        return responce;
    }

    private class IsSidesNotLessThanThree implements ISidesValidator {

        @Override
        public Responce isValid(double[] sides) {
            if (sides == null || sides.length < 3) {
                return new Responce(false, "Triangle must have 3 sides.");
            }
            return new Responce(true);
        }
    }
}
