package task3TrianglesSorting.domains;

import task3TrianglesSorting.misc.ShapeData;
import utilities.MathUtilities;

import java.math.RoundingMode;

public class Triangle extends Shape{

    public Triangle(String name, double[] parameters) {
        super(name, parameters);
    }

    public Triangle(ShapeData data) {
        super(data.getString(), data.getDoubles());
    }

    @Override
    public String toString() {
        return String.format("[%s]: %s cm", getName(),
                MathUtilities.round(getValue(), 2, RoundingMode.HALF_UP));
    }
}
