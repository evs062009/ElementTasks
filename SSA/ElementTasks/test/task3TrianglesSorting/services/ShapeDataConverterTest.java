package task3TrianglesSorting.services;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import task3TrianglesSorting.misc.ShapeData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void convertWithCorrectInputReturnsShapeData() {
        String input = "name, 1.5, 2.5, 3.5";
        String name = "name";
        double[] doubles = {1.5, 2.5, 3.5};
        ShapeData expected = new ShapeData(name, doubles);

        ShapeData actual = converter.convert(input, separator);

        assertEquals(expected, actual);
    }

    @Test
    public void convertWithNullInputReturnsNull() {
        ShapeData actual = converter.convert(null, separator);
        assertNull(actual);
    }

    @Test
    public void convertWithEmptyInputReturnsNull() {
        ShapeData actual = converter.convert("", separator);
        assertNull(actual);
    }

    @Test
    public void convertWithLessThanTwoParametersReturnsNull() {
        ShapeData actual = converter.convert("name ", separator);
        assertNull(actual);
    }

    @Test
    public void convertWithInputWithMissedSeparatorReturnsNull() {
        String input = "name, 1.5, 2.5 3.5";
        ShapeData actual = converter.convert(input, separator);
        assertNull(actual);
    }

    @Test
    public void convertCannotConvertStringToDoubleAndReturnsNull() {
        String input = "name, asg, 2.5 3.5";
        ShapeData actual = converter.convert(input, separator);
        assertNull(actual);
    }
}