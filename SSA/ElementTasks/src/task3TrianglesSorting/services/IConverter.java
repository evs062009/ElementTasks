package task3TrianglesSorting.services;

import task3TrianglesSorting.misc.ShapeData;

public interface IConverter {
    ShapeData convert(String parameters) throws IllegalArgumentException;
}
