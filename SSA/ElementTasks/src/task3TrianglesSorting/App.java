package task3TrianglesSorting;

import task3TrianglesSorting.domains.Triangle;
import task3TrianglesSorting.input.ITrianglesInput;
import task3TrianglesSorting.output.ITrianglesOutput;
import task3TrianglesSorting.services.ITrianglesSorting;

import java.util.List;

public class App {

    private ITrianglesInput input;
    private ITrianglesSorting sorting;
    private ITrianglesOutput output;

    App(ITrianglesInput input, ITrianglesSorting sorting,
        ITrianglesOutput output) {
        this.input = input;
        this.sorting = sorting;
        this.output = output;
    }

    void execute() {
        List<Triangle> triangles = input.inputTriangles();
        sorting.sortTriangles(triangles);
        output.printTriangles(triangles);
    }
}
