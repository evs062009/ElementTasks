package task2EnvelopeAnalysis.analysis;

import task2EnvelopeAnalysis.domains.Envelope;

import java.util.List;
import java.util.Optional;

public class NestingAbilityAnalysis implements IEnvelopesAnalysis {

    @Override
    public boolean analyseEnvelopes(List<Envelope> envelopes)
            throws IllegalArgumentException {
        if (envelopes == null || envelopes.isEmpty()) {
            throw new IllegalArgumentException("There is no envelopes for analysis.");
        }
        return analyseNestingAbility(envelopes);
    }

    private boolean analyseNestingAbility(List<Envelope> envelopes) {
        Optional<Envelope> maxEnvelopeOpt = Optional.of(envelopes.get(0));
        for (int i = 1; i < envelopes.size(); i++) {
            //FIXME
            //ВОЗВРАЩ ПРАВИЛЬНЫЙ ПУСТОЙ oPTIONAL? НО В ЦИКЛЕ ЕГО НЕ УСПЕВАЕТ ОБРАБАТЫВАТЬ
            if (maxEnvelopeOpt.isPresent()) {
                maxEnvelopeOpt = getMaxEnvelopeOpt(maxEnvelopeOpt.get(), envelopes.get(i));
            } else {
                return false;
            }
        }
        return true;
    }

    private Optional<Envelope> getMaxEnvelopeOpt(Envelope envelope1, Envelope envelope2) {
        if (envelope1.getMaxSide() > envelope2.getMaxSide()
                && envelope1.getMinSide() > envelope2.getMinSide()) {
            return Optional.of(envelope1);
        }
        if (envelope2.getMaxSide() > envelope1.getMaxSide()
                && envelope2.getMinSide() > envelope1.getMinSide()) {
            return Optional.of(envelope2);
        }
        return Optional.empty();
    }
}
