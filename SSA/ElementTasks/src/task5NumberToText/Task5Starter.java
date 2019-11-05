package task5NumberToText;

import common.input.ConsoleInput;
import common.input.IInput;
import common.interfaces.IStarter;
import task5NumberToText.mappers.IMapper;
import task5NumberToText.mappers.Mapper;
import task5NumberToText.services.IProcessor;
import task5NumberToText.services.Processor;
import task5NumberToText.validators.IValidator;
import task5NumberToText.validators.Validator;

public class Task5Starter implements IStarter {
    @Override
    public void startApp() {
        IInput input = new ConsoleInput();
        IValidator validator = new Validator();
        IMapper mapper = new Mapper();
        IProcessor processor = new Processor(mapper);
        App app = new App(input, validator, processor);
        app.execute();
    }
}
