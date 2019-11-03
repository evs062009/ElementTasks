package task2EnvelopeAnalysis.domains;

import task2EnvelopeAnalysis.dto.EnvelopeDto;

public class Envelope {

    private double sideA;
    private double sideB;

    private double maxSide;
    private double minSide;

    public Envelope(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
        if (sideA > sideB) {
            maxSide = sideA;
            minSide = sideB;
        } else {
            maxSide = sideB;
            minSide = sideA;
        }
    }

    public Envelope(EnvelopeDto dto) {
        this(dto.getSideA(), dto.getSideB());
    }

    public double getMaxSide() {
        return maxSide;
    }

    public double getMinSide() {
        return minSide;
    }
}
