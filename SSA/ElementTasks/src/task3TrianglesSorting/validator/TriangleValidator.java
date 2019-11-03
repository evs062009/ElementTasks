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
        List<ISidesValidator> validators = Arrays.asList(
                new IsSidesGreaterThanZero(),
                new IsEachSideLessSumOtherTwo());

        for (ISidesValidator validator : validators) {
            Responce responce = validator.isValid(data.getDoubles());
            if (!responce.isValid()) {
                return responce;
            }
        }
        return new Responce(true);
    }
}
