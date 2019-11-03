package task2EnvelopeAnalysis.domains;

import task2EnvelopeAnalysis.misc.ContainerData;

public abstract class Container {

    private double[] parameters;

    public Container(ContainerData data) {
        parameters = data.getData();
    }

    public double[] getParameters() {
        return parameters;
    }

    public void setParameters(double[] parameters) {
        this.parameters = parameters;
    }
}
