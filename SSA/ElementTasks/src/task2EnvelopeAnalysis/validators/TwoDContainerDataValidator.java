package task2EnvelopeAnalysis.validators;

import task2EnvelopeAnalysis.misc.ContainerData;

public class TwoDContainerDataValidator implements IContainerDataValidator {

    @Override
    public boolean isValid(ContainerData data) {
        if (data != null && data.getData() != null){
            double[] doubles = data.getData();
            if (doubles.length > 1) {
                for (double number : doubles) {
                    if (number <= 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
