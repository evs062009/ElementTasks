package task4FileParser.services.fileReplacers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReplacer implements IFileReplacer {

    /**
     * Replaces all occurrences of old sting to new string in the file.
     *
     * @param strFromFile a string from the contents of the file in which the changes will be performed.
     * @param pathStr     the path to the file in string format.
     * @param oldStr      the string which will be replaced.
     * @param newStr      the string for replacing.
     * @throws IOException in cases the file does not exist, can not be opened, can not be rewrote etc.
     */
    @Override
    public void replaceInFile(String strFromFile, String pathStr, String oldStr, String newStr)
            throws IOException {
        Path path = Paths.get(pathStr);
        String stringToFile = strFromFile.replace(oldStr, newStr);
        Files.write(path, stringToFile.getBytes());
    }
}
