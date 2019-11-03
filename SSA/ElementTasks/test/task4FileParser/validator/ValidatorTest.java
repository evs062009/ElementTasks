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
    public void validatorGetValidArguments() {
        //GIVEN
        String filePath = "some path";
        String firstString = "one";
        String secondString = "two";
        //WHEN
        String[] actual = {filePath, firstString, secondString};
        boolean isValid = validator.isValid(actual);
        //THEN
        assertTrue(isValid);
    }

    @Test
    public void validatorGetNull() {
        //GIVEN
        //WHEN
        boolean isValid = validator.isValid(null);
        //THEN
        assertFalse(isValid);
    }

    @Test
    public void validatorGetEmptyArguments() {
        //GIVEN
        //WHEN
        String[] actual = {""};
        boolean isValid = validator.isValid(actual);
        //THEN
        assertFalse(isValid);
    }

    @Test
    public void validatorGetLessThanTwoArguments() {
        //GIVEN
        //WHEN
        String[] actual = {"onlyOne"};
        boolean isValid = validator.isValid(actual);
        //THEN
        assertFalse(isValid);
    }
}