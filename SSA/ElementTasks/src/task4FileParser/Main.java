package task4FileParser;

import task4FileParser.services.FileProcessor;
import task4FileParser.services.IFileProcessor;
import task4FileParser.validators.IValidator;
import task4FileParser.validators.Validator;
import utilities.IOUtilities;

public class Main {
    public static void main(String[] args) {
        IValidator validator = new Validator();
        IFileProcessor processor = new FileProcessor();

        if (validator.isValid(args)) {
            processor.process(args);
        } else {
            IOUtilities.println("For string matching counting it needs 2 "
                    .concat("parameters: path to the file and string.\n")
                    .concat("For string replacing it needs 3 parameters: path to ")
                    .concat("the file, search string, string for replace."));
        }
    }
}
