package task3TrianglesSorting.services;

import task3TrianglesSorting.domains.Triangle;

import java.util.List;

public class TrianglesSortingByArea implements ITrianglesSorting {

    @Override
    public void sortTriangleArr(List<Triangle> trianglesArr) {
        trianglesArr.sort((o1, o2) -> Double.compare(o2.getArea(),
                o1.getArea()));
    }
}
