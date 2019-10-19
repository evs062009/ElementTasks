package task3TrianglesSorting.output;

import task3TrianglesSorting.domains.Triangle;

import java.util.List;

public class ConsoleTrianglesOutput implements ITrianglesOutput {

    @Override
    public void printTriangles(List<Triangle> triangles) {
        System.out.println("============= Triangles list: ===============");
        for (int i = 0; i < triangles.size(); i++) {
            System.out.printf("%s. %s%n", i + 1, triangles.get(i).toString());
        }
    }
}
