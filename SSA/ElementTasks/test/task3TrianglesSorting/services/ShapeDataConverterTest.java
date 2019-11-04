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
        
        String input = "name, 1.5, 2.5, 3.5";
        String name = "name";
        double[] doubles = {1.5, 2.5, 3.5};
        ShapeData expected = new ShapeData(name, doubles);
        
        ShapeData actual = converter.convert(input, separator);
        
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertNullInput() {
        
        converter.convert(null, separator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertEmptyInput() {
        
        String input = "";
        
        converter.convert(input, separator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertLessThanTwoParameters() {
        
        String input = "name ";
        
        converter.convert(input, separator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertGetInputWithMissedSeparator() {
        
        String input = "name, 1.5, 2.5 3.5";
        
        converter.convert(input, separator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertCannotConvertDoubleToString() {
        
        String input = "name, asg, 2.5 3.5";
        
        converter.convert(input, separator);
    }
}