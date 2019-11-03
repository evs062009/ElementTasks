package task2EnvelopeAnalysis;

import common.input.IInput;
import task2EnvelopeAnalysis.services.analysis.IContainerAnalysis;
import task2EnvelopeAnalysis.services.converters.IContainerDataConverter;
import task2EnvelopeAnalysis.domains.Container;
import task2EnvelopeAnalysis.domains.TwoDContainer;
import task2EnvelopeAnalysis.misc.ContainerData;
import task2EnvelopeAnalysis.output.IEnvelopesOutput;
import task2EnvelopeAnalysis.validators.IContainerDataValidator;
import utilities.IOUtilities;

import java.util.ArrayList;

class App {

    private IInput input;
    private IContainerDataConverter converter;
    private IContainerDataValidator validator;
    private IContainerAnalysis analysis;
    private IEnvelopesOutput output;

    App(IInput input, IContainerDataConverter converter, IContainerDataValidator validator,
        IContainerAnalysis analysis, IEnvelopesOutput output) {
        this.input = input;
        this.converter = converter;
        this.validator = validator;
        this.analysis = analysis;
        this.output = output;
    }

    void execute() {
        ArrayList<Container> containers = new ArrayList<>();

        do {
            String separator = " ";
            String message = String.format("Input envelope sizes, divided by '%s' (like sideA sideB): ",
                    separator);
            String string = input.input(message);
            ContainerData data = converter.convert(string, separator);
            if (validator.isValid(data)) {
                containers.add(new TwoDContainer(data));
            } else {
                IOUtilities.println("Invalid input data.");
            }
        } while (IOUtilities.isContinue());

        boolean result = analysis.analyse(containers);
        output.printAnalysesResult(result);
    }
}
