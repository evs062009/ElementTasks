package utilities;

public class Validators {
    public static String message;

    private Validators() {
    }

    public static boolean isNotNull(Object o) {
        if (o != null) {
            clearMessage();
            return true;
        }
        message = "is null";
        return false;
    }

    public static boolean isStringArrLengthMore(String[] arr, int than) {
        if (arr.length > than) {
            clearMessage();
            return true;
        }
        message = String.format("length not more than %s", than);
        return false;
    }

    public static boolean isStringArrLengthLess(String[] arr, int than) {
        if (arr.length < than) {
            clearMessage();
            return true;
        }
        message = String.format("length not more than %s", than);
        return false;
    }
    public static boolean isPositive(Double number) {
        if (number > 0) {
            return true;
        } else {
            message = String.format("%s is not positive.", number);
            return false;
        }
    }

    private static void clearMessage() {
        message = "";
    }
}
