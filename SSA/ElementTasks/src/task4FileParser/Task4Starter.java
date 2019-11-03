package task4FileParser;

import common.input.ConsoleInput;
import common.input.IInput;
import common.interfaces.IStarter;
import task4FileParser.services.fileReplacers.FileReplacer;
import task4FileParser.services.fileReplacers.IFileReplacer;
import task4FileParser.services.matchCounters.IMatchCounter;
import task4FileParser.services.matchCounters.MatchCounter;
import task4FileParser.validator.IValidator;
import task4FileParser.validator.Validator;

public class Task4Starter implements IStarter {

    @Override
    public void startApp() {
        IInput input = new ConsoleInput();
        IValidator validator = new Validator();
        IMatchCounter matchCounter = new MatchCounter();
        IFileReplacer replacer = new FileReplacer();
        Task4 app = new Task4(input, validator, matchCounter, replacer);
        app.execute();
    }
}
