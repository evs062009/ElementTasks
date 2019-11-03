package task2EnvelopeAnalysis.output;

import utilities.IOUtilities;

public class ConsoleEnvelopesOutput implements IEnvelopesOutput {

    @Override
    public void printAnalysesResult(boolean res) {
        String addStr = (res) ? ("") : ("not ");
        IOUtilities.print(String.format(
                "Envelopes can %sbe nested one into another.%n", addStr));
    }
}
