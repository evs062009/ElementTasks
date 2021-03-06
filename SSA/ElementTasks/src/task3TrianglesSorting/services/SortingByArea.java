package task3TrianglesSorting.services;

import org.jetbrains.annotations.NotNull;
import task3TrianglesSorting.domains.Shape;

import java.util.Comparator;
import java.util.List;

public class SortingByArea implements IService {

    /**
     * Sorts the list of shapes by their ResultValue in descending order.
     * @param shapes list of shapes for sorting
     */
    @Override
    public void process(List<Shape> shapes) {
        shapes.sort(getComparator());
    }

    @NotNull
    private Comparator<Shape> getComparator() {
        return (o1, o2) -> Double.compare(o2.getResultValue(),
                o1.getResultValue());
    }
}
