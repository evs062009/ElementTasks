package task3TrianglesSorting.services;

import task3TrianglesSorting.domains.Triangle;

import java.util.List;

public class TrianglesSortingByArea implements ITrianglesSorting {

    @Override
    public void sortTriangles(List<Triangle> triangles) {
        triangles.sort((o1, o2) -> Double.compare(o2.getArea(),
                o1.getArea()));
    }
}
