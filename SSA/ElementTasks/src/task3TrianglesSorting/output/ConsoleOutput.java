package task3TrianglesSorting.output;

import task3TrianglesSorting.domains.Shape;

import java.util.List;

public class ConsoleOutput implements IOutput {

    @Override
    public void print(List<Shape> shapes) {
        System.out.println("============= Triangles list: ===============");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.printf("%s. %s%n", i + 1, shapes.get(i).toString());
        }
    }
}
