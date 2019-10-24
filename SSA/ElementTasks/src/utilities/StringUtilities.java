package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class StringUtilities {

    public static void replaceInFile(String file, String oldString,
                                      String newString) throws IOException {
        String stringFromFile = getStringFromFile(file);
        String stringToFile = stringFromFile.replace(oldString, newString);
        Files.write(Paths.get(file), stringToFile.getBytes());
    }

    public static int countStringMatching(String file, String searchString)
            throws IOException {
        String stringFromFile = getStringFromFile(file);
        return (stringFromFile.length() - stringFromFile.replace(searchString,
                "").length()) / searchString.length();
    }

    public static String getStringFromFile (String file) throws IOException {
        return Files.lines(Paths.get(file)).collect(Collectors.joining());
    }
}
