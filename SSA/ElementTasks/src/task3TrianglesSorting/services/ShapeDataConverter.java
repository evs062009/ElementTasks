package task3TrianglesSorting.services;

import task3TrianglesSorting.misc.ShapeData;

import java.util.Arrays;

public class ShapeDataConverter implements IConverter {

    @Override
    public ShapeData convert(String parameters) throws IllegalArgumentException {
        if (parameters == null || parameters.isEmpty()) {
            throw new IllegalArgumentException("Invalid input string.");
        }

        String[] paramArr = parameters.split(",");
        if (paramArr.length < 2) {
            throw new IllegalArgumentException("Too few parameters.");
        }

        double[] doubles;
        try {
            doubles = Arrays.stream(paramArr).skip(1).mapToDouble(Double::parseDouble).toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input parameters can not be parsed to double: " + e.getMessage());
        }
        return new ShapeData(paramArr[0], doubles);
    }
}
