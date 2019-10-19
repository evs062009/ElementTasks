package task3TrianglesSorting.validators;

import task3TrianglesSorting.dto.TriangleDto;

public class TriangleValidator implements ITriangleValidator {

    @Override
    public void validateTriangleData(TriangleDto dto)
            throws IllegalArgumentException{
        if (dto.getSides().length != 3) {
            throw new  IllegalArgumentException(
                    "Invalid triangle. It has to have 3 sides");
        }
        for (int i = 0; i < dto.getSides().length; i++) {
            validateSideNotLessZero(dto.getSides()[i], i + 1);
        }
        validateSidesLessSumOtherTwo(dto.getSides());
    }

    private void validateSideNotLessZero(double side, int sideNumber)
            throws IllegalArgumentException {
        if (side < 0) {
            throw new IllegalArgumentException(
                    String.format(
                            "Invalid triangle. Side %s has to be not less than 0.",
                            sideNumber));
        }
    }

    private void validateSidesLessSumOtherTwo(double[] sides)
            throws IllegalArgumentException {
        double sum = 0;
        for (double side : sides) {
            sum += side;
        }
        for (int i = 0; i < sides.length; i++) {
            double sumOtherTwo = sum - sides[i];
            if (sides[i] >= sumOtherTwo) {
                throw new IllegalArgumentException(String.format(
                        "Invalid triangle. Side %s can not be greater than sum of other two sides.",
                        i + 1));
            }
        }
    }
}
