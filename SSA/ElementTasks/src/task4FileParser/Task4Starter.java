package task4FileParser;

import common.interfaces.IStarter;
import task3TrianglesSorting.validator.IShapeValidator;

public class Task4Starter implements IStarter {

    @Override
    public void startApp() {
        IShapeValidator validator = new Vali;
        IFileProcessor processor = new FileProcessorOnTempFile(args);
    }
}
