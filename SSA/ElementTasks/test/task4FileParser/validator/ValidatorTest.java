package task4FileParser.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {

    private IValidator validator;

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void validatorWithValidArgumentsReturnsTrue() {
        String filePath = "some path";
        String firstString = "one";
        String secondString = "two";
        String[] actual = {filePath, firstString, secondString};
        boolean isValid = validator.isValid(actual);
        assertTrue(isValid);
    }

    @Test
    public void validatorWithNullReturnsFalse() {
        boolean isValid = validator.isValid(null);
        assertFalse(isValid);
    }

    @Test
    public void validatorWithEmptyArgumentsReturnsFalse() {
        String[] actual = {""};
        boolean isValid = validator.isValid(actual);
        assertFalse(isValid);
    }

    @Test
    public void validatorWithLessThanTwoArgumentsReturnsFalse() {
        String[] actual = {"onlyOne"};
        boolean isValid = validator.isValid(actual);
        assertFalse(isValid);
    }
}