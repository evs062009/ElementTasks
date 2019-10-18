package task3TrianglesSorting.input;

import task3TrianglesSorting.domains.Triangle;
import utilities.InputUtilities;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConsoleTrianglesInput implements ITrianglesInput {

    private static final String Y = "y";
    private static final String YES = "yes";

    @Override
    public List<Triangle> inputTriangles() {
        List<Triangle> triangles = new LinkedList<>();
        do {
            try {
                triangles.add(getNewTriangle());
            } catch (Exception ex) {
                System.out.printf("Invalid triangle. Reason: %s%n",
                        ex.getMessage());
            }
        } while (isContinue());
        return triangles;
    }

    private Triangle getNewTriangle() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input triangle name: ");
        String name = sc.nextLine().trim();

        double[] sides = new double[3];
        for (int i = 1; i <= sides.length; i++) {
            sides[i] = inputSideLength(i);
        }
        return new Triangle(name, sides);
    }

    private double inputSideLength(int i) throws NumberFormatException {
        System.out.printf("Input length of side %s:", i);
        return InputUtilities.input();
    }

    private boolean isContinue() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("For adding another triangle input '%s' or '%s'. "
                .concat("For finish input another symbol: "), Y, YES);
        String input = sc.next().trim();
        return Y.equalsIgnoreCase(input) || YES.equalsIgnoreCase(input);
    }
}
