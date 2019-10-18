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
    public List<Triangle> getTrianglesArr() {
        List<Triangle> triangleList = new LinkedList<>();
        do {
            try {
                triangleList.add(getNewTriangle());
            } catch (Exception ex) {
                System.out.println("Invalid triangle. Reason: "
                        + ex.getMessage());
            }
        } while (isContinue());
        return triangleList;
    }

    private Triangle getNewTriangle() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input triangle name: ");
        String name = sc.nextLine().trim();

        double[] sides = new double[3];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = inputSideLength(i);
        }
        return new Triangle(name, sides);
    }

    private double inputSideLength(int i) throws NumberFormatException {
        System.out.print("Input length of side " + (i + 1) + ": ");
        return InputUtilities.input();
    }

    private boolean isContinue() {
        Scanner sc = new Scanner(System.in);

        System.out.print("For adding another triangle input '" + Y + "' or '"
                + YES + "'. For finish input another symbol: ");
        String input = sc.next().trim();
        return Y.equalsIgnoreCase(input) || YES.equalsIgnoreCase(input);
    }
}
