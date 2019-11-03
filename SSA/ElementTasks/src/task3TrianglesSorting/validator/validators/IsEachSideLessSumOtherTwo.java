package task3TrianglesSorting.validator.validators;

import common.interfaces.IValidator;

public class IsEachSideLessSumOtherTwo implements ISidesValidator {

    @Override
    public IValidator.Responce isValid(double[] sides) {
        double sum = 0;
        for (double side : sides) {
            sum += side;
        }
        for (double side : sides) {
            double sumOtherTwo = sum - side;
            if (side >= sumOtherTwo) {
                return new IValidator.Responce(false,
                        String.format("Side %s can not be greater than sum of other two sides.", side));
            }
        }
        return new IValidator.Responce(true);
    }
}
