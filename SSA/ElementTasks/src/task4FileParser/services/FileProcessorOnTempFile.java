package task4FileParser.services;

import utilities.IOUtilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileProcessorOnTempFile implements IFileProcessor {
    private String path;
    private int[] original;
    private int i;
    private int count;

    public FileProcessorOnTempFile(String[] args) {
        this.path = args[0];
        this.original = args[1].chars().toArray();
    }

    @Override
    public void process(String[] args) {
        String message = "";
        try {
            IntStream stream = Files.lines(Paths.get(path)).flatMapToInt(CharSequence::chars)
                    .filter(c -> c != '\n');

            if (args.length == 2) {
                message = countMatch(stream);
            } else if (args.length == 3) {
                message = replace(args[2], stream);
            }

        } catch (IOException e) {
            message = Arrays.toString(e.getStackTrace());
        }
        IOUtilities.println(message);
    }

    private String countMatch(IntStream stream) {
        stream.forEach(this::countMatch);
        return String.format("Number of occurrences = %s", count);
    }

    private String replace(String arg, IntStream stream) throws IOException {
        List<Integer> buffer = new LinkedList<>();
        File temp = new File("D:\\temp.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
        int[] newString = arg.chars().toArray();

        temp.createNewFile();
        stream.forEach(c -> replace(c, buffer, writer, newString));
        if (buffer.size() != 0) {
            writeFromList(writer, buffer);
            buffer.clear();
        }

        writer.close();
        Files.copy(Paths.get(temp.getPath()), Paths.get(path),
                StandardCopyOption.REPLACE_EXISTING);
        return "Replaced has been done.";
    }

    private void replace(int symbol, List<Integer> buffer, BufferedWriter writer,
                         int[] newString) {
        if (symbol != original[i]) {
            if (buffer.size() != 0) {
                writeFromList(writer, buffer);
                buffer.clear();
            }
            try {
                writer.write(symbol);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            buffer.add(symbol);
            i++;
            if (i == original.length) {
                writeFromList(writer, Arrays.stream(newString)
                        .boxed().collect(Collectors.toList()));
                buffer.clear();
                i = 0;
            }
        }
    }

    private void writeFromList(BufferedWriter writer, List<Integer> list) {
        try {
            for (int symbol : list) {
                writer.write(symbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void countMatch(int symbol) {
        if (symbol == original[i]) {
            i++;
            if (i == original.length) {
                count++;
                i = 0;
            }
        }
    }

//    @Override
//    public void process(String[] args) {
//        BufferedReader reader;
//        File file = new File(args[0]);
//
//        int fileSymbol;
//
//        int count = 0;
//
//        //XXX version with streams
//
//        if (args.length == 2) {
//            try {
//                reader = new BufferedReader(new FileReader(file));
//
//                while ((fileSymbol = reader.read()) != -1) {
//                    if (fileSymbol != '\n') {
//                        if (fileSymbol == original[i]) {
//                            i++;
//                            if (i == original.length) {
//                                count++;
//                                i = 0;
//                            }
//                        }
//                    }
//                }
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            IOUtilities.println(String.format(
//                    "Number of occurrences = %s", count));
//
//        } else if (args.length == 3) {
//            File temp = new File("D:\\temp.txt");
//            List<Integer> buffer = new LinkedList<>();
//
//            try {
//                temp.createNewFile();
//                reader = new BufferedReader(new FileReader(file));
//                BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
//                int[] newString = args[2].chars().toArray();
//
//                while ((fileSymbol = reader.read()) != -1) {
//                    if (fileSymbol != '\n') {
//                        if (fileSymbol != original[i]) {
//                            if (buffer.size() != 0) {
//                                writeFromList(writer, buffer);
//                                buffer.clear();
//                            }
//                            writer.write(fileSymbol);
//                        } else {
//                            buffer.add(fileSymbol);
//                            i++;
//                            if (i == original.length) {
//                                writeFromList(writer, Arrays.stream(newString)
//                                        .boxed().collect(Collectors.toList()));
//                                buffer.clear();
//                                i = 0;
//                            }
//                        }
//                    }
//                }
//                //XXX code copy
//                if (buffer.size() != 0) {
//                    writeFromList(writer, buffer);
//                    buffer.clear();
//                }
//
//                reader.close();
//                writer.close();
//                Files.copy(Paths.get(temp.getPath()), Paths.get(file.getPath()),
//                        StandardCopyOption.REPLACE_EXISTING);
//                IOUtilities.println("Replaced has been done.");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
