package task2EnvelopeAnalysis.domains;

public class Envelope {

    private double sideA;
    private double sideB;

    private double maxSide;
    private double minSide;

    public Envelope(double sideA, double sideB)
            throws IllegalArgumentException {
        validate(sideA, sideB);
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

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getMaxSide() {
        return maxSide;
    }

    public double getMinSide() {
        return minSide;
    }

    private void validate(double a, double b) throws IllegalArgumentException {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException(
                    "Envelope sides have to be greater than 0.");
        }
    }
}
