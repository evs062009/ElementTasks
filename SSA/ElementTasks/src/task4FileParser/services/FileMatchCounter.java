package task4FileParser.services;

public class FileMatchCounter implements IFileProcessor {

    /**
     * Counts the number of occurrences of one string in another.
     * @param args two parameters:
     *             the string where the search will take place,
     *             and the string that will be searched.
     * @return the number of occurrences.
     */
    @Override
    public int process(String... args) {
        String strFromFile = args[0];
        String searchStr = args[1];
        return (strFromFile.length() - strFromFile.replace(searchStr, "").length())
                / searchStr.length();
    }
}
