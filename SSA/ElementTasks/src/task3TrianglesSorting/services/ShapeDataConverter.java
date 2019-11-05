package task3TrianglesSorting.services;

import org.jetbrains.annotations.Nullable;
import task3TrianglesSorting.misc.ShapeData;

import java.util.Arrays;

public class ShapeDataConverter implements IConverter {

    /**
     * Parses input string to one string and double array creates ShapeData and returns it.
     *
     * @param parameters parameters that are being converted to data for creating a shape.
     * @param separator  the delimiting symbol for splitting the parameters string to an array.
     * @return the data for creating a shape, or {@code null} if parameters can not be converted
     * to the {@link ShapeData}.
     */
    @Override
    @Nullable
    public ShapeData convert(String parameters, String separator) {

        if (parameters != null && !parameters.isEmpty()) {
            String[] paramArr = parameters.trim().split(separator);

            if (paramArr.length > 1) {
                double[] doubles;

                try {
                    doubles = Arrays.stream(paramArr).skip(1).map(String::trim)
                            .mapToDouble(Double::parseDouble).toArray();
                } catch (NumberFormatException e) {
                    return null;
                }
                return new ShapeData(paramArr[0].trim(), doubles);
            }
        }
        return null;
    }
}
