package task5NumberToText;

import common.input.ConsoleInput;
import common.input.IInput;
import common.interfaces.IStarter;
import task5NumberToText.mappers.IMapper;
import task5NumberToText.mappers.Mapper;
import task5NumberToText.services.IProcessor;
import task5NumberToText.services.NumberProcessor;

public class Task5Starter implements IStarter {
    @Override
    public void startApp() {
        IInput input = new ConsoleInput();
        IMapper mapper = new Mapper();
        IProcessor processor = new NumberProcessor(mapper);
        App app = new App(input, processor);
        app.execute();
    }
}
