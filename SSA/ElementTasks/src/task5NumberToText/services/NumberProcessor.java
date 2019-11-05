package task5NumberToText.services;

import task5NumberToText.mappers.IMapper;
import utilities.MathUtilities;

import java.util.ArrayList;
import java.util.List;

public class NumberProcessor implements IProcessor {
    private IMapper mapper;

    public NumberProcessor(IMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String process(long number) {
        String string;
        if (number == 0) {
            return mapper.getZero();
        }
        return processNotZeroString(number);
    }

    private String processNotZeroString(long number) {
        String prefix = (number < 0) ? (mapper.getMinus()) : ("");
        List<Integer> numberBlocks = new ArrayList<>();
        long temp = 0;
        do {
            numberBlocks.add((int) (number % 1000));
            number /= 1000;
        } while (number > 0);
        // FIXME: 11/5/2019
//        numberBlocks.forEach(System.out::println);
        //
        return prefix + mapCharsBlocksToString(numberBlocks);
    }

    private String mapCharsBlocksToString(List<Integer> integers) {
        StringBuilder builder = new StringBuilder();

        for (int i = integers.size() - 1; i >= 0; i--) {
            int number = integers.get(i);

            for (int j = 2, digit = j + 1; j >= 0; j--, digit--) {
                int divider = MathUtilities.pow(10, j);
                builder.append(mapper.getNumberName(digit, number / divider));
                if (j == 1) {
                    if (number > 19 || number < 11) {
                        digit--;
                    }
                }
                number %= divider;
            }
//        // FIXME: 11/5/2019
            System.out.println(number);
//            if (i == 1) {
//
//            }

        }
//        // FIXME: 11/5/2019
        System.out.println(builder);

        return null;
        //
    }

    private int charToInt(char[] chars, int index) {
        final int shift = 48;
        return Math.max(chars[index] - shift, 0);
    }
}
