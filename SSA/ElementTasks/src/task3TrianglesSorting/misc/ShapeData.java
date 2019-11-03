package task3TrianglesSorting.misc;

import java.util.Arrays;

public class ShapeData {
    private String string;
    private double[] doubles;

    public ShapeData(String string, double[] doubles) {
        this.string = string;
        this.doubles = doubles;
    }

    public String getString() {
        return string;
    }

    public double[] getDoubles() {
        return doubles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShapeData)) return false;

        ShapeData shapeData = (ShapeData) o;

        if (!getString().equals(shapeData.getString())) return false;
        return Arrays.equals(getDoubles(), shapeData.getDoubles());
    }

    @Override
    public int hashCode() {
        int result = getString().hashCode();
        result = 31 * result + Arrays.hashCode(getDoubles());
        return result;
    }
}
