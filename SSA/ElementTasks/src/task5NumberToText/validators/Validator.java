package task5NumberToText.validators;

public class Validator implements IValidator {
    @Override
    public boolean isValid(String string) {
        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
