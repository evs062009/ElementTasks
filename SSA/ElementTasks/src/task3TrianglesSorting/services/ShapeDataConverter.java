package task3TrianglesSorting.services;

import task3TrianglesSorting.misc.ShapeData;

import java.util.Arrays;
import java.util.Optional;

public class ShapeDataConverter implements IConverter {

    /**
     * Parses input string to one string and double array creates ShapeData and returns it.
     *
     * @param parameters parameters that are being converted to data for creating a shape.
     * @param separator  the delimiting symbol for splitting the parameters string to an array.
     * @return {@link Optional} with {@link ShapeData}, or empty {@link Optional} if parameters
     * can not be converted to the {@link ShapeData}.
     */
    @Override
    public Optional<ShapeData> convert(String parameters, String separator) {
        if (parameters != null && !parameters.isEmpty()) {
            String[] paramArr = parameters.trim().split(separator);

            if (paramArr.length > 1) {
                double[] doubles;

                try {
                    doubles = Arrays.stream(paramArr).skip(1).map(String::trim)
                            .mapToDouble(Double::parseDouble).toArray();
                } catch (NumberFormatException e) {
                    return Optional.empty();
                }
                return Optional.of(new ShapeData(paramArr[0].trim(), doubles));
            }
        }
        return Optional.empty();
    }
}
