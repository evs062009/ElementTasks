package task2EnvelopeAnalysis.services.converters;

import task2EnvelopeAnalysis.misc.ContainerData;

public interface IContainerDataConverter {

    ContainerData convert(String string, String separator);
}
