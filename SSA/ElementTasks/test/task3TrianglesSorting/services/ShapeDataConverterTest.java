package task3TrianglesSorting.services;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import task3TrianglesSorting.misc.ShapeData;

import static org.junit.Assert.assertEquals;

public class ShapeDataConverterTest {

    private IConverter converter;
    private static String separator;

    @BeforeClass
    public static void init() {
        separator = ", ";
    }

    @Before
    public void setUp() {
        converter = new ShapeDataConverter();
    }

    @Test
    public void convertCorrectInput() {
        //GIVEN
        String input = "name, 1.5, 2.5, 3.5";
        String name = "name";
        double[] doubles = {1.5, 2.5, 3.5};
        ShapeData expected = new ShapeData(name, doubles);
        //WHEN
        ShapeData actual = converter.convert(input, separator);
        //THEN
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertNullInput() {
        //WHEN
        converter.convert(null, separator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertEmptyInput() {
        //GIVEN
        String input = "";
        //WHEN
        converter.convert(input, separator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertLessThanTwoParameters() {
        //GIVEN
        String input = "name ";
        //WHEN
        converter.convert(input, separator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertGetInputWithMissedSeparator() {
        //GIVEN
        String input = "name, 1.5, 2.5 3.5";
        //WHEN
        converter.convert(input, separator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertCannotConvertDoubleToString() {
        //GIVEN
        String input = "name, asg, 2.5 3.5";
        //WHEN
        converter.convert(input, separator);
    }
}