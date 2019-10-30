package task3TrianglesSorting.services;

import task3TrianglesSorting.domains.Triangle;

public class TriangleFactory implements IFactory {

    @Override
    public Triangle create(String[] parameters) {
        String name = parameters[0].trim();
        double[] sides = new double[3];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = Double.parseDouble((parameters[i + 1]).trim());
        }
        Triangle triangle = new Triangle(name, sides);
        triangle.setValue(getHeronTriangleArea(sides[0], sides[1], sides[2]));
        return triangle;
    }

    private double getHeronTriangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
