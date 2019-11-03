package task2EnvelopeAnalysis.validators;

import task2EnvelopeAnalysis.dto.EnvelopeDto;

public class EnvelopeValidator implements IEnvelopeValidator {

    @Override
    public void validateEnvelopeData(EnvelopeDto dto)
            throws IllegalArgumentException {
        if (dto.getSideA() <= 0 || dto.getSideB() <= 0) {
            throw new IllegalArgumentException(
                    "Envelope sides have to be greater than 0.");
        }
    }
}
