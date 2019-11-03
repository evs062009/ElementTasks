package task3TrianglesSorting.input;

import common.interfaces.IInput;
import utilities.IOUtilities;

public class ConsoleInput implements IInput {

    @Override
    public String input() {
        return IOUtilities.inputString(
                "Input triangle parameters divided with comma (like name, side A, side B, side C): ");
    }
}
