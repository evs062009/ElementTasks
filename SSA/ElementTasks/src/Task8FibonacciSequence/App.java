package Task8FibonacciSequence;

import utilities.IOUtilities;

import java.util.List;

public class App {

    public void execute(String[] args) {
        String invalid = "Invalid arguments: ";

        if (args != null && args.length > 0) {
            List<Long> fibonacchi;

            if (args.length == 1) {
                int numberLong = 0;
                try {
                    numberLong = Integer.parseInt(args[0]);
                } catch (NumberFormatException e) {
                    IOUtilities.println(invalid);
                }

                //fixme при 3 получается 9000, а надо 999
                long threshold = Math.round(9 * Math.pow(10, numberLong));

                //fixme delete
                System.out.println(threshold);
                //

            } else if (args.length == 2) {

            }

//            try {
//                number = Integer.parseInt(args[0]);
//                exp = Integer.parseInt(args[1]);
//            } catch (NumberFormatException e) {
//                IOUtilities.println(invalid + e.getMessage());
//            }
//            int result = MathUtilities.pow(number, exp);
//            IOUtilities.println(String.format("%s pow %s = %s", number, exp, result));
//        } else {
//            IOUtilities.println(invalid);
//        }
//
//        System.out.println(fibonacchi);
        }
        IOUtilities.println(invalid + "no arguments.");

//    private static List<Long> fibonacchi(long threshold) {
//        List<Long> fibonacchi = new ArrayList<>();
//        fibonacchi.add(1L);
//        long x = 1;
//        long y = 1;
//        long f = 1;
//
//        while (f < threshold) {
//            fibonacchi.add(f);
//            f = x + y;
//            x = y;
//            y = f;
//        }
//        return fibonacchi;
    }
}

