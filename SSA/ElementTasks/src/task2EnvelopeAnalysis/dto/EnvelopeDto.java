package task2EnvelopeAnalysis.dto;

public class EnvelopeDto {

    private double sideA;
    private double sideB;

    public EnvelopeDto(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }
}
