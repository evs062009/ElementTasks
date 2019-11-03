package task3TrianglesSorting.domains;

public abstract class Shape {
    private String name;
    private double[] parameters;
    private double value;

    public Shape(String name, double[] parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
