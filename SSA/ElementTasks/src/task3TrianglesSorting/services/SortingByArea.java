package task3TrianglesSorting.services;

import task3TrianglesSorting.domains.Triangle;

import java.util.List;

public class SortingByArea implements IService {

    @Override
    public void process(List<Triangle> triangles) {
        triangles.sort((o1, o2) -> Double.compare(o2.getArea(),
                o1.getArea()));
    }
}
