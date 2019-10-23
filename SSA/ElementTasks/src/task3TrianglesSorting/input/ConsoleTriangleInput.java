package task3TrianglesSorting.input;

import task3TrianglesSorting.dto.TriangleDto;
import utilities.IOUtilities;

public class ConsoleTriangleInput implements ITriangleInput {

    @Override
    public TriangleDto inputTriangleData() throws NumberFormatException {
        String name = inputName();
        double[] sides = new double[3];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = inputSideLength(i + 1);
        }
        return new TriangleDto(name, sides);
    }

    private String inputName() {
        return IOUtilities.inputString("Input triangle name: ").trim();
    }

    private double inputSideLength(int sideNumber) throws NumberFormatException {
        return IOUtilities.inputDouble(
                String.format("Input length of side %s: ", sideNumber));
    }
}
