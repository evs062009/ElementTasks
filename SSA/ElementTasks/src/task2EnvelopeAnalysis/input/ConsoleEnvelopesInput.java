package task2EnvelopeAnalysis.input;

import task2EnvelopeAnalysis.dto.EnvelopeDto;
import utilities.IOUtilities;

public class ConsoleEnvelopesInput implements IEnvelopesInput {

    @Override
    public EnvelopeDto inputEnvelopsData(int envelopeNumber)
            throws NumberFormatException {

        double[] sides = new double[2];
        for (int i = 0; i < 2; i++) {
            sides[i] = IOUtilities.inputDouble(String.format(
                    "Input length of side %s for Envelope %s: ", i + 1,
                    envelopeNumber));
        }
        return new EnvelopeDto(sides[0], sides[1]);
    }
}
