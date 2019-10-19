package task2EnvelopeAnalysis.analysis;

import task2EnvelopeAnalysis.domains.Envelope;

import java.util.List;

public class NestingAbilityAnalysis implements IEnvelopesAnalysis {

    @Override
    public boolean analyseEnvelopes(List<Envelope> envelopes) {
        Envelope maxEnvelope = envelopes.get(0);
        for (int i = 1; i < envelopes.size(); i++) {
            maxEnvelope = getMaxEnvelopeOpt(maxEnvelope, envelopes.get(i));
            if (maxEnvelope == null) {
                return false;
            }
        }
        return true;
    }

    private Envelope getMaxEnvelopeOpt(Envelope envelope1, Envelope envelope2) {
        if (envelope1.getMaxSide() > envelope2.getMaxSide()
                && envelope1.getMinSide() > envelope2.getMinSide()) {
            return envelope1;
        }
        if (envelope2.getMaxSide() > envelope1.getMaxSide()
                && envelope2.getMinSide() > envelope1.getMinSide()) {
            return envelope2;
        }
        return null;
    }
}
