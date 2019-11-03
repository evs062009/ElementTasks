package task3TrianglesSorting.services;

import task3TrianglesSorting.domains.Shape;

import java.util.List;

public class SortingByArea implements IService {

    @Override
    public void process(List<Shape> shapes) {
        shapes.sort((o1, o2) -> Double.compare(o2.getValue(),
                o1.getValue()));
    }
}
