package task3TrianglesSorting.services;

import org.junit.Before;
import org.junit.Test;
import task3TrianglesSorting.domains.Shape;
import task3TrianglesSorting.domains.Triangle;
import task3TrianglesSorting.misc.ShapeData;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortingByAreaTest {

    private IService sorter;
    @Before
    public void setUp() {
        sorter = new SortingByArea();
    }

    @Test
    public void sortedDesc() {
        //GIVEN
        double[] bigSides = {3.5, 4.5, 5.5};
        double[] mediumSides = {2.5, 3.5, 4.5};
        double[] smallSides = {1.5, 2.5, 3.5};

        Triangle bigTriangle = new Triangle(new ShapeData("big", bigSides));
        Triangle mediumTriangle = new Triangle(new ShapeData("medium", mediumSides));
        Triangle smallTriangle = new Triangle(new ShapeData("small", smallSides));

        List<Shape> expected = Arrays.asList(bigTriangle, mediumTriangle, smallTriangle);
        List<Shape> actual = Arrays.asList(mediumTriangle, smallTriangle, bigTriangle);
        //WHEN
        sorter.process(actual);
        //THEN
        assertEquals(expected, actual);
    }
}