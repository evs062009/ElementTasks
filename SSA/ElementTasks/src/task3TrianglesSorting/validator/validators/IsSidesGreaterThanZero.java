package task3TrianglesSorting.validator.validators;

import common.interfaces.IValidator;

public class IsSidesGreaterThanZero implements ISidesValidator {

    @Override
    public IValidator.Response isValid(double[] sides) {
        for (double parameter : sides) {
            if (parameter <= 0) {
                return new IValidator.Response(false,
                        String.format("Side have to be greater than zero: %s.", parameter));
            }
        }
        return new IValidator.Response(true);
    }
}
