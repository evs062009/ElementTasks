package task2EnvelopeAnalysis.validators;

import task2EnvelopeAnalysis.dto.EnvelopeDto;

public interface IEnvelopeValidator {

    void validateEnvelopeData(EnvelopeDto dto) throws IllegalArgumentException;
}
