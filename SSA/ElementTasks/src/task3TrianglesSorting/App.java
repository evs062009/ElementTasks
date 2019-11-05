package task3TrianglesSorting;

import common.input.IInput;
import common.misc.Response;
import task3TrianglesSorting.domains.Shape;
import task3TrianglesSorting.domains.Triangle;
import task3TrianglesSorting.misc.ShapeData;
import task3TrianglesSorting.output.IOutput;
import task3TrianglesSorting.services.IConverter;
import task3TrianglesSorting.services.IService;
import task3TrianglesSorting.validator.IShapeValidator;
import utilities.IOUtilities;

import java.util.LinkedList;
import java.util.List;

public class App {
    /*The main logic of application.*/

    private IInput input;
    private IConverter converter;
    private IShapeValidator validator;
    private IService sorting;
    private IOutput output;

    App(IInput input, IConverter converter, IShapeValidator validator, IService sorting,
        IOutput output) {
        this.input = input;
        this.converter = converter;
        this.validator = validator;
        this.sorting = sorting;
        this.output = output;
    }

    public void execute() {
        List<Shape> shapes = new LinkedList<>();

        do {
            fillShapes(shapes);
        } while (IOUtilities.isContinue());

        sorting.process(shapes);
        output.print(shapes);
    }

    private void fillShapes(List<Shape> shapes) {
        Response response;
        String message = String.format(
                "Input triangle parameters divided with '%s' (like name, side A, side B, side C): ",
                getSeparator());
        String inputStr = input.input(message);
        ShapeData data = converter.convert(inputStr, getSeparator());

        if (data == null) {
            IOUtilities.println("Invalid input parameters.");
            return;
        } else {
            response = validator.isValid(data);
        }

        if (response.isValid()) {
            shapes.add(new Triangle(data));
        } else {
            IOUtilities.println(response.getMessage());
        }
    }

    private String getSeparator() {
        return ",";
    }
}
