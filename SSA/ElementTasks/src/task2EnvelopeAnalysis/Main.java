package task2EnvelopeAnalysis;

import task2EnvelopeAnalysis.analysis.IEnvelopesAnalysis;
import task2EnvelopeAnalysis.analysis.NestingAbilityAnalysis;
import task2EnvelopeAnalysis.input.ConsoleEnvelopesInput;
import task2EnvelopeAnalysis.input.IEnvelopesInput;
import task2EnvelopeAnalysis.output.ConsoleEnvelopesOutput;
import task2EnvelopeAnalysis.output.IEnvelopesOutput;

public class Main {
    public static void main(String[] args) {
        IEnvelopesInput input = new ConsoleEnvelopesInput();
        IEnvelopesAnalysis analysis = new NestingAbilityAnalysis();
        IEnvelopesOutput output = new ConsoleEnvelopesOutput();
        App app = new App(input, analysis, output);
        app.execute();
    }
}
