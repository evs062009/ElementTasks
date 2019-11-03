package task4FileParser;

import common.input.ConsoleInput;
import common.input.IInput;
import common.interfaces.IStarter;
import task4FileParser.services.FileProcessorOnMemory;
import task4FileParser.services.IFileProcessor;
import task4FileParser.validator.FileParserValidator;
import task4FileParser.validator.IFileParserValidator;

public class Task4Starter implements IStarter {

    @Override
    public void startApp() {
        IInput input = new ConsoleInput();
        IFileParserValidator validator = new FileParserValidator();
        IFileProcessor processor = new FileProcessorOnMemory();
        Task4 app = new Task4(input, validator, processor);
        app.execute();
    }
}
