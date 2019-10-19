package task2EnvelopeAnalysis.input;

import task2EnvelopeAnalysis.domains.Envelope;
import utilities.IOUtilities;

import java.util.ArrayList;
import java.util.List;

public class ConsoleEnvelopesInput implements IEnvelopesInput {

    @Override
    public List<Envelope> inputEnvelops() {
        int envelopeNumber = 2;
        List<Envelope> envelopes = new ArrayList<>(envelopeNumber);

        for (int i = 1; i <= envelopeNumber; i++) {
            try {
                IOUtilities.print(String.format(
                        "Input length of side A for Envelope %s:", i));
                double sideA = IOUtilities.inputDouble();
                IOUtilities.print(String.format(
                        "Input length of side B for Envelope %s:", i));
                double sideB = IOUtilities.inputDouble();
                envelopes.add(new Envelope(sideA, sideB));
            } catch (IllegalArgumentException ex) {
                IOUtilities.print(String.format(
                        "Wrong envelope sides. Reason: %s. Repeat input.%n",
                        ex.getMessage()));
                i--;
            }
        }
        return envelopes;
    }
}
