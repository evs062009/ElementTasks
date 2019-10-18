package task3TrianglesSorting.domains;

import utilities.MathUtilities;

public class Triangle {

    private String name;
    private double[] sides;
    private double area;

    public Triangle(String name, double[] sides)
            throws IllegalArgumentException {
        validate(sides);
        this.name = name;
        this.sides = sides;
        this.area = getHeronTriangleArea(sides[0], sides[1], sides[2]);
    }

    public String getName() {
        return name;
    }

    public double[] getSides() {
        return sides;
    }

    public double getArea() {
        return area;
    }

    private void validate(double[] sides) throws IllegalArgumentException {
        if (sides.length != 3) {
            throw new IllegalArgumentException("Triangle has to have 3 sides");
        }
        for (int i = 1; i <= sides.length; i++) {
            validateSideNotLessZero(sides[i], i);
        }
        validateSidesLessSumOtherTwo(sides);
    }

    private void validateSideNotLessZero(double side, int i)
            throws IllegalArgumentException {
        if (side < 0) {
            throw new IllegalArgumentException(
                    "Side " + i + " has to be not less than 0.");
        }
    }

    private void validateSidesLessSumOtherTwo(double[] sides)
            throws IllegalArgumentException {
        double sum = 0;
        for (double side : sides) {
            sum += side;
        }
        for (int i = 1; i <= sides.length; i++) {
            double sumOtherTwo = sum - sides[i];
            if (sides[i] >= sumOtherTwo) {
                throw new IllegalArgumentException("Side " + i
                        + " can not be greater than sum of other two sides.");
            }
        }
    }

    /*
     * For correct working of this method its arguments need to be checked.
     * In this implementation checking has done in constructor
     */
    private double getHeronTriangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String toString() {
        return "[" + name + "]: " + MathUtilities.round(area, 2) + " cm";
    }
}
