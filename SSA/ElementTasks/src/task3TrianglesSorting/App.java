package task3TrianglesSorting;

import common.interfaces.IInput;
import common.interfaces.IValidator;
import task3TrianglesSorting.domains.Shape;
import task3TrianglesSorting.domains.Triangle;
import task3TrianglesSorting.misc.ShapeData;
import task3TrianglesSorting.output.IOutput;
import task3TrianglesSorting.services.IConverter;
import task3TrianglesSorting.services.IService;
import utilities.IOUtilities;

import java.util.LinkedList;
import java.util.List;

class App {
    /*The main logic of application.*/

    private IInput input;
    private IConverter converter;
    private IValidator validator;
    private IService sorting;
    private IOutput output;

    App(IInput input, IConverter converter, IValidator validator, IService sorting,
        IOutput output) {
        this.input = input;
        this.converter = converter;
        this.validator = validator;
        this.sorting = sorting;
        this.output = output;
    }

    void execute() {
        List<Shape> shapes = new LinkedList<>();
        ShapeData data;
        do {
            String inputStr = input.input();

            try {
                data = converter.convert(inputStr);
            } catch (IllegalArgumentException ex) {
                IOUtilities.println(ex.getMessage());
                continue;
            }

            IValidator.Response response = validator.isValid(data);
            if (response.isValid()) {
                shapes.add(new Triangle(data));
            } else {
                IOUtilities.println(response.getMessage());
            }
        } while (IOUtilities.isContinue());

        sorting.process(shapes);
        output.print(shapes);
    }
}
