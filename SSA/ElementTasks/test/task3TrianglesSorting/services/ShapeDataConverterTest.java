package task3TrianglesSorting.services;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import task3TrianglesSorting.misc.ShapeData;

import java.util.Optional;

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
    public void convertWithCorrectInputReturnsShapeData() {
        String input = "name, 1.5, 2.5, 3.5";
        String name = "name";
        double[] doubles = {1.5, 2.5, 3.5};
        Optional<ShapeData> expected = Optional.of(new ShapeData(name, doubles));

        Optional<ShapeData> actual = converter.convert(input, separator);

        assertEquals(expected, actual);
    }

    @Test
    public void convertWithNullInputReturnsEmptyOptional() {
        Optional<ShapeData> expected = Optional.empty();
        Optional<ShapeData> actual = converter.convert(null, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void convertWithEmptyInputReturnsEmptyOptional() {
        Optional<ShapeData> expected = Optional.empty();
        Optional<ShapeData> actual = converter.convert("", separator);
        assertEquals(expected, actual);
    }

    @Test
    public void convertWithLessThanTwoParametersReturnsEmptyOptional() {
        Optional<ShapeData> expected = Optional.empty();
        Optional<ShapeData> actual = converter.convert("name ", separator);
        assertEquals(expected, actual);
    }

    @Test
    public void convertWithInputWithMissedSeparatorReturnsEmptyOptional() {
        Optional<ShapeData> expected = Optional.empty();
        String input = "name, 1.5, 2.5 3.5";
        Optional<ShapeData> actual = converter.convert(input, separator);
        assertEquals(expected, actual);
    }

    @Test
    public void convertCannotConvertStringToDoubleAndReturnsEmptyOptional() {
        Optional<ShapeData> expected = Optional.empty();
        String input = "name, asg, 2.5 3.5";
        Optional<ShapeData> actual = converter.convert(input, separator);
        assertEquals(expected, actual);
    }
}