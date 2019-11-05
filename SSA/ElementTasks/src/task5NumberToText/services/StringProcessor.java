package task5NumberToText.services;

import task5NumberToText.mappers.IMapper;

import java.util.ArrayList;
import java.util.List;

// FIXME: 11/5/2019 not using
public class StringProcessor /*implements IProcessor*/ {
    private IMapper mapper;

    public StringProcessor(IMapper mapper) {
        this.mapper = mapper;
    }

//    @Override
    public String process(String string) {
        if (string == null || string.isEmpty()) {
            return "Invalid input parameter.";
        }
        if ("0".equals(string)) {
            return mapper.getZero();
        }
        return processNotZeroString(string);
    }

    private String processNotZeroString(String string) {
        String prefix = "";
        if (string.startsWith("-")) {
            prefix = mapper.getMinus();
            string = string.substring(1);
        }
        List<char[]> charsBlocks = getBlocksList(string);
        // FIXME: 11/5/2019
        charsBlocks.forEach(System.out::println);
        //
        return prefix + mapCharsBlocksToString(charsBlocks);
    }

    private List<char[]> getBlocksList(String string) {
        List<char[]> charsBlocks = new ArrayList<>();
        int lastIndex = string.length() - 1;
        for (int i = lastIndex; i >= 0; i--) {
            int loopNumber = (lastIndex - i) % 3;

            if (loopNumber == 0) {
                charsBlocks.add(new char[3]);
            }
            charsBlocks.get((lastIndex - i) / 3)[loopNumber] = string.charAt(i);
        }
        return charsBlocks;
    }

    private String mapCharsBlocksToString(List<char[]> charsBlocks) {
        StringBuilder builder = new StringBuilder();

        for (int i = charsBlocks.size() - 1; i >= 0 ; i--) {
            char[] chars = charsBlocks.get(i);

            for (int j = chars.length - 1, digit = chars.length; j >= 0; j--, digit--) {
                if (j == 0) {
                    if (charToInt(chars, 1) != 1) {
                        digit--;
                    }
                }
                builder.append(mapper.getNumberName(digit, charToInt(chars, j)));
            }

//            if (i == 1) {
//
//            }

        }
        // FIXME: 11/5/2019
        System.out.println(builder);
        return null;
        //
    }

    private int charToInt(char[] chars, int index) {
        final int shift = 48;
        return Math.max(chars[index] - shift, 0);
    }
}
