package common.input;

import utilities.IOUtilities;

public class ConsoleInput implements IInput {

    @Override
    public String input(String message) {
        return IOUtilities.inputString(message);
    }
}
