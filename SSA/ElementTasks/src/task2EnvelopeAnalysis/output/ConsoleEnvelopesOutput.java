package task2EnvelopeAnalysis.output;

public class ConsoleEnvelopesOutput implements IEnvelopesOutput {

    @Override
    public void printAnalysesResult(boolean res) {
        String addStr = (res) ? ("") : ("not ");
        System.out.printf(
                "Envelopes can %sbe nested one into another.%n", addStr);
    }

    public void printMessage(String message) {
        System.out.println(message);
        System.out.println();
    }
}
