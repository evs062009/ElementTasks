package task4FileParser.services.fileReplacers;

import java.io.IOException;

public interface IFileReplacer {
    void replaceInFile(String strFromFile, String pathStr, String oldStr, String newStr) throws IOException;
}
