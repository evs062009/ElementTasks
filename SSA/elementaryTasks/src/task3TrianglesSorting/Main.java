package task3TrianglesSorting;

import task3TrianglesSorting.input.ConsoleTrianglesInput;
import task3TrianglesSorting.input.ITrianglesInput;
import task3TrianglesSorting.output.ConsoleTrianglesOutput;
import task3TrianglesSorting.output.ITrianglesOutput;
import task3TrianglesSorting.services.ITrianglesSorting;
import task3TrianglesSorting.services.TrianglesSortingByArea;

public class Main {
    public static void main(String[] args) {
        ITrianglesInput input = new ConsoleTrianglesInput();
        ITrianglesSorting sorting = new TrianglesSortingByArea();
        ITrianglesOutput output = new ConsoleTrianglesOutput();
        App app = new App(input, sorting, output);
        app.execute();
    }
}
