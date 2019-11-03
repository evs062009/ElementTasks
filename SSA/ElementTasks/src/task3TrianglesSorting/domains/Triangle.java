package task3TrianglesSorting.domains;

import task3TrianglesSorting.misc.ShapeData;
import utilities.MathUtilities;

import java.math.RoundingMode;

public class Triangle extends Shape{

    public Triangle(ShapeData data) {
        super(data.getString(), data.getDoubles());
        setResultValue(getHeronTriangleArea(data.getDoubles()[0], data.getDoubles()[1], data.getDoubles()[2]));
    }

    @Override
    public String toString() {
        return String.format("[%s]: %s cm", getName(),
                MathUtilities.round(getResultValue(), 2, RoundingMode.HALF_UP));
    }

    private double getHeronTriangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
