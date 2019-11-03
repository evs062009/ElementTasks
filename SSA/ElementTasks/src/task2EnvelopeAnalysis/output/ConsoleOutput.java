package task2EnvelopeAnalysis.output;

import utilities.IOUtilities;

public class ConsoleOutput implements IEnvelopesOutput {

    @Override
    public void printAnalysesResult(boolean res) {
        String addStr = (res) ? ("") : ("NOT ");
        IOUtilities.print(String.format("Envelopes can %sbe nested.%n", addStr));
    }
}
