package task2EnvelopeAnalysis.domains;

import task2EnvelopeAnalysis.misc.ContainerData;

public class TwoDContainer extends Container {

    private double maxSide;
    private double minSide;

    public TwoDContainer(ContainerData data) {
        super(data);
        double sideA = data.getData()[0];
        double sideB = data.getData()[1];
        maxSide = Double.max(sideA, sideB);
        minSide = (maxSide == sideA) ? (sideB) : (sideA);
    }

    public double getMaxSide() {
        return maxSide;
    }

    public double getMinSide() {
        return minSide;
    }
}
