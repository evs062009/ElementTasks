package task3TrianglesSorting.dto;

public class TriangleDto {

    private String name;
    private double[] sides;

    public TriangleDto(String name, double[] sides) {
        this.name = name;
        this.sides = sides;
    }

    public String getName() {
        return name;
    }

    public double[] getSides() {
        return sides;
    }
}
