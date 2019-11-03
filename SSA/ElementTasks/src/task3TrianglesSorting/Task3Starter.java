/*
 * SSA Elementary task #3.
 * Sorts triangles by area descending.
 */
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
import task3TrianglesSorting.validator.IShapeValidator;
import task3TrianglesSorting.validator.TriangleValidator;

public class Task3Starter implements IStarter {

    public void startApp(){
        /*Starts application*/

        IInput input = new ConsoleInput();
        IConverter converter = new ShapeDataConverter();
        IShapeValidator validator = new TriangleValidator();
        IService service = new SortingByArea();
        IOutput output = new ConsoleOutput();
        Task3 app = new Task3(input, converter, validator, service, output);
        app.execute();
    }
}
