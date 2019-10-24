package task4FileParser.validators;

import task4FileParser.validators.IValidator;
import utilities.IOUtilities;
import utilities.Validators;

public class Validator implements IValidator {

    @Override
    public boolean isValid(String[] args) {
        return Validators.isNotNull(args)
                && Validators.isStringArrLengthMore(args, 1)
                && Validators.isStringArrLengthLess(args, 4);
    }
}
