package task4FileParser.services.matchCounters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatchCounterTest {
    private IMatchCounter counter;

    @Before
    public void setUp() {
        counter = new MatchCounter();
    }

    @Test
    public void countTwoOccurrencesReturns2() {
        String string = "aaabbbAAAcccaaaDDD";
        String searchStr = "aaa";
        int expected = 2;
        int actual = counter.count(string, searchStr);
        assertEquals(expected, actual);
    }

    @Test
    public void countNoOccurrencesReturns0() {
        String string = "bbbAAAcccDDD";
        String searchStr = "aaa";
        int expected = 0;
        int actual = counter.count(string, searchStr);
        assertEquals(expected, actual);
    }

    @Test
    public void countInEmptyStringReturns0() {
        String string = "";
        String searchStr = "aaa";
        int expected = 0;
        int actual = counter.count(string, searchStr);
        assertEquals(expected, actual);
    }
}