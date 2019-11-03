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
        //GIVEN
        String string = "aaabbbAAAcccaaaDDD";
        String searchStr = "aaa";
        int expected = 2;
        //WHEN
        int actual = counter.count(string, searchStr);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void countNoOccurrencesReturns0() {
        //GIVEN
        String string = "bbbAAAcccDDD";
        String searchStr = "aaa";
        int expected = 0;
        //WHEN
        int actual = counter.count(string, searchStr);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    public void countInEmptyStringReturns0() {
        //GIVEN
        String string = "";
        String searchStr = "aaa";
        int expected = 0;
        //WHEN
        int actual = counter.count(string, searchStr);
        //THEN
        assertEquals(expected, actual);
    }
}