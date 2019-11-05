package task3TrianglesSorting.services;

import task3TrianglesSorting.misc.ShapeData;

import java.util.Optional;

public interface IConverter {
    Optional<ShapeData> convert(String parameters, String separator) throws IllegalArgumentException;
}
