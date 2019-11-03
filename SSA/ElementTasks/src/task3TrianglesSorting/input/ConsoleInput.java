package task3TrianglesSorting.input;

import utilities.IOUtilities;

public class ConsoleInput implements IInput {

    @Override
    public String[] inputParameters() throws NumberFormatException {
        IOUtilities.print("Input triangle name (" +
                "like name, Side A length, Side B length, Side C length: ");
        String input = IOUtilities.inputString(null);
        return input.trim().split(",");
    }
}
