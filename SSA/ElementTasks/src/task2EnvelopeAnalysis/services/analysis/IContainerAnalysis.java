package task2EnvelopeAnalysis.services.analysis;


import task2EnvelopeAnalysis.domains.Container;

import java.util.List;

public interface IContainerAnalysis {

    boolean analyse(List<Container> containers);
}
