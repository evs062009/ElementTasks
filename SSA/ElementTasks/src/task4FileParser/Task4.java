package task4FileParser;

import common.input.IInput;
import task4FileParser.services.IFileProcessor;
import task4FileParser.validator.IFileParserValidator;

class Task4 {

    private IInput input;
    private IFileParserValidator validator;
    private IFileProcessor processor;

    Task4(IInput input, IFileParserValidator validator, IFileProcessor processor) {
        this.input = input;
        this.validator = validator;
        this.processor = processor;
    }

    void execute() {
        while (true) {
            String separator = ";";
            String message = String.format("Input parameters divided by '%s'\n.", separator)
                    .concat("2 for string matching counting: path to the file and string.\n")
                    .concat("3 for string replacing: path to the file, search string and string for replace.\n")
                    .concat("For exit input 'exit'");
            String string = input.input(message).trim();

            if ("exit".equalsIgnoreCase(string)) {
                break;
            }

            String[] args = string.split(separator);
            if (validator.isValid(args)) {
                processor.process(args);
            }
        }
    }
}
