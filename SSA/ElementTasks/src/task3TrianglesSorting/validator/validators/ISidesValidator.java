package task3TrianglesSorting.validator.validators;

import common.interfaces.IValidator;

public interface ISidesValidator {

    IValidator.Response isValid(double[] sides);
}
