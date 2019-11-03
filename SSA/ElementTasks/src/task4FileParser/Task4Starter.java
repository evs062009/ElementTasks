package task4FileParser;

import common.input.ConsoleInput;
import common.input.IInput;
import common.interfaces.IStarter;
import task4FileParser.services.FileReplacer;
import task4FileParser.services.FileMatchCounter;
import task4FileParser.services.IFileProcessor;
import task4FileParser.validator.Validator;
import task4FileParser.validator.IValidator;

public class Task4Starter implements IStarter {

    @Override
    public void startApp() {
        IInput input = new ConsoleInput();
        IValidator validator = new Validator();
        IFileProcessor matchCounter = new FileMatchCounter();
        IFileProcessor replacer = new FileReplacer();
        Task4 app = new Task4(input, validator, matchCounter, replacer);
        app.execute();
    }
}
