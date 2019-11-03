package task2EnvelopeAnalysis;

import common.input.ConsoleInput;
import common.input.IInput;
import common.interfaces.IStarter;
import task2EnvelopeAnalysis.output.ConsoleOutput;
import task2EnvelopeAnalysis.output.IEnvelopesOutput;
import task2EnvelopeAnalysis.services.analysis.IContainerAnalysis;
import task2EnvelopeAnalysis.services.analysis.TwoDNestingAbilityAnalysis;
import task2EnvelopeAnalysis.services.converters.ContainerDataConverter;
import task2EnvelopeAnalysis.services.converters.IContainerDataConverter;
import task2EnvelopeAnalysis.validators.IContainerDataValidator;
import task2EnvelopeAnalysis.validators.TwoDContainerDataValidator;

public class Task2Starter implements IStarter {

    @Override
    public void startApp() {
        IInput input = new ConsoleInput();
        IContainerDataConverter converter = new ContainerDataConverter();
        IContainerDataValidator validator = new TwoDContainerDataValidator();
        IContainerAnalysis analysis = new TwoDNestingAbilityAnalysis();
        IEnvelopesOutput output = new ConsoleOutput();
        App app = new App(input, converter, validator, analysis, output);
        app.execute();
    }
}
