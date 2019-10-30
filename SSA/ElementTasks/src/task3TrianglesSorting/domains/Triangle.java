package task3TrianglesSorting.domains;

import utilities.MathUtilities;

public class Triangle extends Shape{

    public Triangle(String name, double[] parameters) {
        super(name, parameters);
    }

    public double getArea() {
        return getValue();
    }

    @Override
    public String toString() {
        return String.format("[%s]: %s cm", getName(),
                MathUtilities.round(getValue(), 2));
    }
}
