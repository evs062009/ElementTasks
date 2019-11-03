package task4FileParser.services.fileReplacers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReplacer implements IFileReplacer {

    @Override
    public void replaceInFile(String strFromFile, String pathStr, String oldStr, String newStr)
            throws IOException {
        Path path = Paths.get(pathStr);
        String stringToFile = strFromFile.replace(oldStr, newStr);
        Files.write(path, stringToFile.getBytes());
    }
}
