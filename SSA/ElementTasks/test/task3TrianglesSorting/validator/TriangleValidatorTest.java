package task3TrianglesSorting.validator;

import common.misc.Response;
import org.junit.Before;
import org.junit.Test;
import task3TrianglesSorting.misc.ShapeData;

import static org.junit.Assert.*;

public class TriangleValidatorTest {

    private IShapeValidator validator;

    @Before
    public void setUp() {
        validator = new TriangleValidator();
    }

    @Test
    public void validatorGetValidData() {
        //GIVEN
        String name = "name";
        double[] sides = {1.5, 2.5, 3.5};
        ShapeData data = new ShapeData(name, sides);
        //WHEN
        Response response = validator.isValid(data);
        boolean actual = response.isValid();
        //THEN
        assertTrue(actual);
    }

    @Test
    public void validatorGetOnlyTwoSides() {
        //GIVEN
        String name = "name";
        double[] sides = {1.5, 2.5};
        ShapeData data = new ShapeData(name, sides);
        //WHEN
        Response response = validator.isValid(data);
        boolean actual = response.isValid();
        //THEN
        assertFalse(actual);
    }

    @Test
    public void validatorGetZeroSide() {
        //GIVEN
        String name = "name";
        double[] sides = {1.5, 0, 3.5};
        ShapeData data = new ShapeData(name, sides);
        //WHEN
        Response response = validator.isValid(data);
        boolean actual = response.isValid();
        //THEN
        assertFalse(actual);
    }

    @Test
    public void validatorGetSideLessThanZero() {
        //GIVEN
        String name = "name";
        double[] sides = {1.5, 2.5, -3.5};
        ShapeData data = new ShapeData(name, sides);
        //WHEN
        Response response = validator.isValid(data);
        boolean actual = response.isValid();
        //THEN
        assertFalse(actual);
    }

    @Test
    public void validatorGetOneSideGreaterThanOtherTwo() {
        //GIVEN
        String name = "name";
        double[] sides = {11.5, 2.5, 3.5};
        ShapeData data = new ShapeData(name, sides);
        //WHEN
        Response response = validator.isValid(data);
        boolean actual = response.isValid();
        //THEN
        assertFalse(actual);
    }
}