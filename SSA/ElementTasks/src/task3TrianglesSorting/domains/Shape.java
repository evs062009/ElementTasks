package task3TrianglesSorting.domains;

public abstract class Shape {
    private String name;
    private double[] parameters;
    private double resultValue;

    public Shape(String name, double[] parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public double getResultValue() {
        return resultValue;
    }

    public void setResultValue(double resultValue) {
        this.resultValue = resultValue;
    }
}
