package task5NumberToText;

import common.input.IInput;
import task5NumberToText.services.IProcessor;
import utilities.IOUtilities;

public class App {
    private IInput input;
    private IProcessor processor;

    public App(IInput input, IProcessor processor) {
        this.input = input;
        this.processor = processor;
    }

    public void execute() {
        String string = input.input(String.format("Input a number up to %s: ", Long.MAX_VALUE)).trim();
        long number;
        try {
            number = Long.parseLong(string);
        } catch (NumberFormatException e) {
            IOUtilities.println("Invalid input parameter.");
            return;
        }
        String result = processor.process(number);
        IOUtilities.println(result);
    }
}
