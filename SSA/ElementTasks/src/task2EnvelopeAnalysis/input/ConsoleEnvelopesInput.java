package task2EnvelopeAnalysis.input;

import task2EnvelopeAnalysis.domains.Envelope;
import utilities.InputUtilities;

import java.util.ArrayList;
import java.util.List;

public class ConsoleEnvelopesInput implements IEnvelopesInput {

    @Override
    public List<Envelope> inputEnvelops() {
        int envelopeNumber = 2;
        List<Envelope> envelopes = new ArrayList<>(envelopeNumber);

        for (int i = 1; i <= envelopeNumber; i++) {
            try {
                System.out.print(
                        "Input length of side A for Envelope " + i + ": ");
                double sideA = InputUtilities.input();
                System.out.print(
                        "Input length of side B for Envelope " + i + ": ");
                double sideB = InputUtilities.input();
                envelopes.add(new Envelope(sideA, sideB));
            } catch (IllegalArgumentException ex) {
                System.out.println("Wrong envelope sides. Reason: "
                        + ex.getMessage() + ". Repeat input.");
                i--;
            }
        }
        return envelopes;
    }
}
