package task3TrianglesSorting;

import common.interfaces.IStarter;
import task3TrianglesSorting.input.ConsoleInput;
import common.interfaces.IInput;
import task3TrianglesSorting.output.ConsoleOutput;
import task3TrianglesSorting.output.IOutput;
import task3TrianglesSorting.services.IConverter;
import task3TrianglesSorting.services.IService;
import task3TrianglesSorting.services.SortingByArea;
import task3TrianglesSorting.services.ShapeDataConverter;
import common.interfaces.IValidator;
import task3TrianglesSorting.validator.TriangleValidator;

public class Starter implements IStarter {

    public void startApp(){
        IInput input = new ConsoleInput();
        IValidator validator = new TriangleValidator();
        IConverter factory = new ShapeDataConverter();
        IService service = new SortingByArea();
        IOutput output = new ConsoleOutput();
        App app = new App(input, validator, factory, service, output);
        app.execute();
    }
}
