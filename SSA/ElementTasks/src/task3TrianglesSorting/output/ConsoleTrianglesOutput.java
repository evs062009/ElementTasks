package task3TrianglesSorting.output;

import task3TrianglesSorting.domains.Triangle;

import java.util.List;

public class ConsoleTrianglesOutput implements ITrianglesOutput {

    @Override
    public void printTrianglesArr(List<Triangle> trianglesArr) {
        System.out.println("============= Triangles list: ===============");
        for (int i = 0; i < trianglesArr.size(); i++) {
            System.out.println((i + 1) + ". " + trianglesArr.get(i).toString());
        }
    }
}
