package task2EnvelopeAnalysis.services.analysis;

import task2EnvelopeAnalysis.domains.Container;
import task2EnvelopeAnalysis.domains.TwoDContainer;

import java.util.Comparator;
import java.util.List;

public class TwoDNestingAbilityAnalysis implements IContainerAnalysis {

    @Override
    public boolean analyse(List<Container> containers) {
        if (containers.size() < 2) {
            return false;
        }

        try {
            containers.stream().map(c -> (TwoDContainer) c).sorted(getTwoDContainerComparator());
        } catch (NestingAbilityException | ClassCastException e) {
            return false;
        }
        return true;
    }

    private Comparator<TwoDContainer> getTwoDContainerComparator() throws NestingAbilityException {
        return (c1, c2) -> {
            if (c1.getMaxSide() > c2.getMaxSide() && c1.getMinSide() > c2.getMinSide()) {
                return -1;
            }
            if (c2.getMaxSide() > c1.getMaxSide() && c2.getMinSide() > c1.getMinSide()) {
                return 1;
            }
            throw new NestingAbilityException();
        };
    }

    private class NestingAbilityException extends RuntimeException {
    }
}
