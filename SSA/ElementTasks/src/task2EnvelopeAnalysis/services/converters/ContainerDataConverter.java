package task2EnvelopeAnalysis.services.converters;

import task2EnvelopeAnalysis.misc.ContainerData;

import java.util.Arrays;

public class ContainerDataConverter implements IContainerDataConverter {

    @Override
    public ContainerData convert(String string, String separator) {
        ContainerData data = new ContainerData(new double[0]);

        if (string != null && !string.isEmpty()) {
            String[] strings = string.trim().split(separator);
            double[] doubles;
            try {
                doubles = Arrays.stream(strings).mapToDouble(Double::parseDouble).toArray();
            } catch (NumberFormatException e) {
                return data;
            }
            data = new ContainerData(doubles);
        }
        return data;
    }
}
