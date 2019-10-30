package task3TrianglesSorting;

import task3TrianglesSorting.domains.Shape;
import task3TrianglesSorting.input.IInput;
import task3TrianglesSorting.output.IOutput;
import task3TrianglesSorting.services.IFactory;
import task3TrianglesSorting.services.IService;
import task3TrianglesSorting.validators.IValidator;
import utilities.IOUtilities;

import java.util.LinkedList;
import java.util.List;

class App {

    private IInput input;
    private IValidator validator;
    private IFactory factory;
    private IService sorting;
    private IOutput output;

    App(IInput input, IValidator validator, IFactory factory, IService sorting,
        IOutput output) {
        this.input = input;
        this.validator = validator;
        this.factory = factory;
        this.sorting = sorting;
        this.output = output;
    }

    void execute() {
        List<Shape> shapes = new LinkedList<>();

        do {
            try {
                String[] parameters = input.inputParameters();
                if (validator.validate(parameters)) {
                    shapes.add(factory.create(parameters));
                }
            } catch (IllegalArgumentException ex) {
                IOUtilities.println(ex.getMessage());
            }
        } while (IOUtilities.isContinue());

        sorting.process(shapes);
        output.printTriangles(shapes);
    }
}
