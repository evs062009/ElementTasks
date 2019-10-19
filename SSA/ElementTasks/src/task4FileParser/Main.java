package task4FileParser;

import utilities.IOUtilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        if (args != null && args.length > 1 && args.length < 4) {
            try {
                if (args.length == 2) {
                    int count = countStringMatching(args[0], args[1]);
                    IOUtilities.println(String.format(
                            "Number of occurrences = %s", count));
                } else {
                    replaceInFile(args[0], args[1], args[2]);
                }
            } catch (IOException e) {
                IOUtilities.println(String.format("Invalid file %s.",
                        e.getMessage()));
            }
        } else {
            IOUtilities.println("For string matching counting it needs 2 "
                    .concat("parameters: path to the file and string.\n")
                    .concat("For string replacing it needs 3 parameters: path to ")
                    .concat("the file, search string, string for replace."));
        }
    }

    private static void replaceInFile(String file, String oldString,
                                      String newString) throws IOException {
        String stringFromFile = Files.lines(Paths.get(file)).collect(
                Collectors.joining());
        String stringToFile = stringFromFile.replace(oldString, newString);
        Files.write(Paths.get(file), stringToFile.getBytes());
    }

    private static int countStringMatching(String file, String searchString)
            throws IOException {
        String stringFromFile = Files.lines(Paths.get(file)).collect(
                Collectors.joining());
        return (stringFromFile.length() - stringFromFile.replace(searchString,
                "").length()) / searchString.length();
    }
}
