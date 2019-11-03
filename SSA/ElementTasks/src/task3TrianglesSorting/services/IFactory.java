package task3TrianglesSorting.services;

import task3TrianglesSorting.domains.Shape;

public interface IFactory {
    Shape create(String[] parameters);
}
