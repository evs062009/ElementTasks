package task2EnvelopeAnalysis;

import task2EnvelopeAnalysis.analysis.IEnvelopesAnalysis;
import task2EnvelopeAnalysis.domains.Envelope;
import task2EnvelopeAnalysis.dto.EnvelopeDto;
import task2EnvelopeAnalysis.input.IEnvelopesInput;
import task2EnvelopeAnalysis.output.IEnvelopesOutput;
import task2EnvelopeAnalysis.validators.IEnvelopeValidator;
import utilities.IOUtilities;

import java.util.ArrayList;
import java.util.List;

public class App {

    private IEnvelopesInput input;
    private IEnvelopeValidator validator;
    private IEnvelopesAnalysis analysis;
    private IEnvelopesOutput output;

    public App(IEnvelopesInput input, IEnvelopeValidator validator,
               IEnvelopesAnalysis analysis, IEnvelopesOutput output) {
        this.input = input;
        this.validator = validator;
        this.analysis = analysis;
        this.output = output;
    }

    void execute() {
        do {
            int envelopeNumber = 2;
            boolean result;
            List<Envelope> envelopes = new ArrayList<>(envelopeNumber);

            for (int i = 1; i <= envelopeNumber; i++) {
                try {
                    EnvelopeDto dto = input.inputEnvelopsData(i);
                    validator.validateEnvelopeData(dto);
                    envelopes.add(new Envelope(dto));
                } catch (IllegalArgumentException ex) {
                    IOUtilities.print(String.format(
                            "Wrong envelope sides. Reason: %s Repeat interfaces.%n",
                            ex.getMessage()));
                    i--;
                }
            }

            result = analysis.analyseEnvelopes(envelopes);
            output.printAnalysesResult(result);
        } while (IOUtilities.isContinue());
    }
}
