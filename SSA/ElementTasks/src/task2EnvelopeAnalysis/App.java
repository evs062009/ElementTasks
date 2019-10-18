package task2EnvelopeAnalysis;

import task2EnvelopeAnalysis.analysis.IEnvelopesAnalysis;
import task2EnvelopeAnalysis.domains.Envelope;
import task2EnvelopeAnalysis.input.IEnvelopesInput;
import task2EnvelopeAnalysis.output.IEnvelopesOutput;

import java.util.List;
import java.util.Scanner;

public class App {

    private static final String Y = "y";
    private static final String YES = "yes";

    private IEnvelopesInput input;
    private IEnvelopesAnalysis analysis;
    private IEnvelopesOutput output;

    public App(IEnvelopesInput input, IEnvelopesAnalysis analysis,
               IEnvelopesOutput output) {
        this.input = input;
        this.analysis = analysis;
        this.output = output;
    }

    void execute() {
        do {
            List<Envelope> envelopes = input.inputEnvelops();
            boolean result;
            try {
                result = analysis.analyseEnvelopes(envelopes);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return;
            }
            output.printAnalysesResult(result);
        } while (isContinue());
    }

    private boolean isContinue() {
        Scanner sc = new Scanner(System.in);

        System.out.print("For adding another triangle input '" + Y + "' or '"
                + YES + "'. For finish input another symbol: ");
        String input = sc.next().trim();
        return Y.equalsIgnoreCase(input) || YES.equalsIgnoreCase(input);
    }
}
