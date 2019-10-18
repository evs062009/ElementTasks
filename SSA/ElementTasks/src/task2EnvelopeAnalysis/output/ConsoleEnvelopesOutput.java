package task2EnvelopeAnalysis.output;

public class ConsoleEnvelopesOutput implements IEnvelopesOutput {

    @Override
    public void printAnalysesResult(boolean res) {

        System.out.println("Envelopes can " + ((res) ? ("") : ("not "))
                + "be nested one into another.\n");
    }
}
