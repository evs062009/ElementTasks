package task4FileParser.services;

import utilities.IOUtilities;
import utilities.StringUtilities;

import java.io.IOException;

public class FileProcessor implements IFileProcessor {

    @Override
    public void process(String[] args) {
        try {
            if (args.length == 2) {
                int count = StringUtilities.countStringMatching(args[0],
                        args[1]);
                IOUtilities.println(String.format(
                        "Number of occurrences = %s", count));
            } else if (args.length == 3) {
                StringUtilities.replaceInFile(args[0], args[1], args[2]);
            }
        } catch (IOException e) {
            IOUtilities.println(String.format("Invalid file %s.",
                    e.getMessage()));
        }
    }
}
