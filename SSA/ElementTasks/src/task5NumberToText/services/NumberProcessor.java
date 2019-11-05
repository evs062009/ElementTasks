package task5NumberToText.services;

import org.jetbrains.annotations.NotNull;
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
        if (number == 0) {
            return mapper.getZero();
        }
        return processNotZeroString(number);
    }

    private String processNotZeroString(long number) {
        String prefix = (number < 0) ? (mapper.getMinus()) : ("");
        List<Integer> numberBlocks = new ArrayList<>();
        do {
            numberBlocks.add((int) (number % 1000));
            number /= 1000;
        } while (number > 0);
        return prefix + mapCharsBlocksToString(numberBlocks);
    }

    private String mapCharsBlocksToString(List<Integer> integers) {
        String result = "";
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

            if (i != 0) {
                processDigits(integers, builder, i);
            }
            result = fixThousands(builder.toString());
        }
        return result;
    }

    private void processDigits(List<Integer> integers, StringBuilder builder, int i) {
        int index;
        int end = integers.get(i) % 100;
        end = (end > 19) ? (end % 10) : (end);

        if (end == 1) {
            index = 0;
        } else if (end > 1 && end < 5) {
            index = 1;
        } else {
            index = 2;
        }
        builder.append(mapper.getBlockName(i - 1, index));
    }

    @NotNull
    private String fixThousands(String string) {
        string = string.replace("один тысяча ", "одна тысяча");
        string = string.replace("два тысячи ", "две тысячи");
        return string;
    }
}
