package task4FileParser.services.matchCounters;

public class MatchCounter implements IMatchCounter {

    /**
     * Counts the number of occurrences of one string in another.
     *
     * @param string    the string where the search will take place.
     * @param searchStr the string that will be searched.
     * @return the number of occurrences.
     */
    @Override
    public int count(String string, String searchStr) {
        return (string.length() - string.replace(searchStr, "").length())
                / searchStr.length();
    }
}
