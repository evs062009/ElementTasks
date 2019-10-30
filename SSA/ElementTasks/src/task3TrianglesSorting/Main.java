package task3TrianglesSorting;

import task3TrianglesSorting.input.ConsoleInput;
import task3TrianglesSorting.input.IInput;
import task3TrianglesSorting.output.ConsoleOutput;
import task3TrianglesSorting.output.IOutput;
import task3TrianglesSorting.services.IFactory;
import task3TrianglesSorting.services.IService;
import task3TrianglesSorting.services.SortingByArea;
import task3TrianglesSorting.services.TriangleFactory;
import task3TrianglesSorting.validators.IValidator;
import task3TrianglesSorting.validators.Validator;

public class Main {

    public static void main(String[] args) {
        IInput input = new ConsoleInput();
        IValidator validator = new Validator();
        IFactory factory = new TriangleFactory();
        IService service = new SortingByArea();
        IOutput output = new ConsoleOutput();
        App app = new App(input, validator, factory, service, output);
        app.execute();
    }
}
