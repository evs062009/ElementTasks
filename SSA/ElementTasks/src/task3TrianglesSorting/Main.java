package task3TrianglesSorting;

import task3TrianglesSorting.input.ConsoleTriangleInput;
import task3TrianglesSorting.input.ITriangleInput;
import task3TrianglesSorting.output.ConsoleTrianglesOutput;
import task3TrianglesSorting.output.ITrianglesOutput;
import task3TrianglesSorting.services.ITrianglesSorting;
import task3TrianglesSorting.services.TrianglesSortingByArea;
import task3TrianglesSorting.validators.ITriangleValidator;
import task3TrianglesSorting.validators.TriangleValidator;

public class Main {

    public static void main(String[] args) {
        ITriangleInput input = new ConsoleTriangleInput();
        ITriangleValidator validator = new TriangleValidator();
        ITrianglesSorting sorting = new TrianglesSortingByArea();
        ITrianglesOutput output = new ConsoleTrianglesOutput();
        App app = new App(input, validator, sorting, output);
        app.execute();
    }
}
