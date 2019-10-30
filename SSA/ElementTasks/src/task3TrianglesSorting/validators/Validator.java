package task3TrianglesSorting.validators;

import utilities.IOUtilities;
import utilities.Validators;

public class Validator implements IValidator {

    @Override
    public boolean isValid(String[] args) {
        int sidesNumber = 3;
        double[] doubles;

        boolean isValid = Validators.isNotNull(args)
                && Validators.isStringArrLengthMore(args, 3)
                && Validators.isStringArrLengthLess(args, 5);

        if (isValid) {
            doubles = new double[sidesNumber];
            for (int i = 0; i < doubles.length; i++) {
                try {
                    doubles[i] = Double.parseDouble(args[i + 1]);
                } catch (NumberFormatException e) {
                    IOUtilities.println(String.format("Parameter %s can not be parsed to double.", i + 1));
                    return false;
                }
            }
            for (double d : doubles) {
                if (!Validators.isPositive(d)) {
                    IOUtilities.println(Validators.message);
                    return false;
                }
            }
        } else {
            IOUtilities.println(Validators.message);
            return false;
        }
        return validateSidesLessSumOtherTwo(doubles);
    }

    private boolean validateSidesLessSumOtherTwo(double[] sides) {
        double sum = 0;
        for (double side : sides) {
            sum += side;
        }
        for (int i = 0; i < sides.length; i++) {
            double sumOtherTwo = sum - sides[i];
            if (sides[i] >= sumOtherTwo) {
                IOUtilities.println(String.format(
                        "Invalid triangle. Side %s can not be greater than sum of other two sides.",
                        i + 1));
                return false;
            }
        }
        return true;
    }
}
