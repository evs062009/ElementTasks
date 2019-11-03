package task4FileParser;

import common.input.IInput;
import task4FileParser.services.IFileProcessor;
import task4FileParser.validator.IValidator;
import utilities.IOUtilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class Task4 {

    private IInput input;
    private IValidator validator;
    private IFileProcessor matchCounter;
    private IFileProcessor replacer;

    Task4(IInput input, IValidator validator, IFileProcessor matchCounter, IFileProcessor replacer) {
        this.input = input;
        this.validator = validator;
        this.matchCounter = matchCounter;
        this.replacer = replacer;
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
                String filePath = args[0];
                Path path = Paths.get(filePath);
                String strFromFile = "";
                try {
                    strFromFile = Files.lines(path).collect(Collectors.joining());
                } catch (IOException e) {
                    IOUtilities.println(String.format("Invalid file %s.", e.getMessage()));
                }
                if (args.length == 2) {
//                    args[1]
                    int count = matchCounter.process(new String[]{strFromFile, args[1]});
                    IOUtilities.println(String.format(
                            "Number of occurrences = %s", count));
                } else if (args.length == 3) {
                    int result = replacer.process(new String[]{strFromFile, });
                }
                replacer.process(args);
            }
        }
    }
}
