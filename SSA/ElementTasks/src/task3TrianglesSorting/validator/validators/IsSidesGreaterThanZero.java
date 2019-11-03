package task3TrianglesSorting.validator.validators;

import common.interfaces.IValidator;

public class IsSidesGreaterThanZero implements ISidesValidator {

    @Override
    public IValidator.Responce isValid(double[] sides) {
        for (double parameter : sides) {
            if (parameter <= 0) {
                return new IValidator.Responce(false,
                        String.format("Side have to be greater than zero: %s.", parameter));
            }
        }
        return new IValidator.Responce(true);
    }
}
