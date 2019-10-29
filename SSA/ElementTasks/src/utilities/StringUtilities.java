package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class StringUtilities {

    public static void replaceInFile(String file, String oldString,
                                     String newString) throws IOException {
        String stringFromFile = convertFileToString(file);
        String stringToFile = stringFromFile.replace(oldString, newString);
        Files.write(Paths.get(file), stringToFile.getBytes());
    }

    public static int countStringMatching(String fileName, String searchString)
            throws IOException {
        String stringFromFile = convertFileToString(fileName);
        return (stringFromFile.length() - stringFromFile.replace(searchString,
                "").length()) / searchString.length();
    }

    public static String convertFileToString(String fileName) throws IOException {
        int maxLength = 512000000;
        Path path = Paths.get(fileName);
        File file = path.toFile();
        if (file.length() > maxLength) {
            throw new IOException("Too big file.");
        }
        return Files.lines(path).collect(Collectors.joining());
    }
}
