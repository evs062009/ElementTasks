package task4FileParser.validator;

public class Validator implements IValidator {

    @Override
    public boolean isValid(String[] args) {
        return args != null && args.length > 1;
    }
}
