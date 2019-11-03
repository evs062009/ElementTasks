package task4FileParser.validator;

public class Validator implements IValidator {

    /**
     * Checks if argument array is not null and its length greater than 1.
     *
     * @param args array of string arguments.
     * @return true if argument array is not null and its length greater than 1,
     * false otherwise.
     */
    @Override
    public boolean isValid(String[] args) {
        return args != null && args.length > 1;
    }
}
