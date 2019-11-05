package task5NumberToText;

import common.input.IInput;
import task5NumberToText.services.IProcessor;
import task5NumberToText.validators.IValidator;
import utilities.IOUtilities;

public class App {
    private IInput input;
    private IValidator validator;
    private IProcessor processor;

    public App(IInput input, IValidator validator, IProcessor processor) {
        this.input = input;
        this.validator = validator;
        this.processor = processor;
    }

    public void execute() {
        String string = input.input(String.format("Input a number up to %s: ", Long.MAX_VALUE)).trim();
        String result;
        if (validator.isValid(string)) {
            result = processor.process(string);
        } else {
            result = "Invalid input parameter.";
        }
        IOUtilities.println(result);
    }
}
