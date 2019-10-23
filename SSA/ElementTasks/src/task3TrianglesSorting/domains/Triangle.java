package task3TrianglesSorting.domains;

import task3TrianglesSorting.dto.TriangleDto;
import utilities.MathUtilities;

public class Triangle {

    private String name;
    private double[] sides;
    private double area;

    public Triangle(String name, double[] sides) {
        this.name = name;
        this.sides = sides;
        this.area = getHeronTriangleArea(sides[0], sides[1], sides[2]);
    }

    public Triangle(TriangleDto dto) {
        this(dto.getName(), dto.getSides());
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return String.format("[%s]: %s cm", name,
                MathUtilities.round(area, 2));
    }

    private static double getHeronTriangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
