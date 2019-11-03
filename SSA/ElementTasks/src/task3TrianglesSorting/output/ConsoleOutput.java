package task3TrianglesSorting.output;

import task3TrianglesSorting.domains.Shape;
import utilities.IOUtilities;

import java.util.List;

public class ConsoleOutput implements IOutput {

    /**
     * Outputs list of shapes.
     * @param shapes list of shapes.
     */
    @Override
    public void print(List<Shape> shapes) {
        IOUtilities.println("============= Triangles list: ===============");
        for (int i = 0; i < shapes.size(); i++) {
            IOUtilities.print(String.format("%s. %s%n", i + 1, shapes.get(i).toString()));
        }
    }
}
