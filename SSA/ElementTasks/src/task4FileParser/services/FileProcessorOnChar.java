package task4FileParser.services;

import utilities.IOUtilities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessorOnChar implements IFileProcessor {

    @Override
    public void process(String[] args) {
        BufferedReader reader;
        File file = new File(args[0]);
        int[] original = args[1].chars().toArray();
        int fileSymbol;
        int i = 0;
        int count = 0;

        if (args.length == 2) {
            try {
                reader = new BufferedReader(new FileReader(file));

                while ((fileSymbol = reader.read()) != -1) {
                    if (fileSymbol != '\n') {
                        if (fileSymbol == original[i]) {
                            i++;
                            if (i == original.length) {
                                count++;
                                i = 0;
                            }
                        }
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            IOUtilities.println(String.format(
                    "Number of occurrences = %s", count));

        } else if (args.length == 3) {
            File temp = new File("D:\\temp.txt");
            List<Integer> buffer = new LinkedList<>();

            try {
                temp.createNewFile();
                reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                int[] newString = args[2].chars().toArray();

                while ((fileSymbol = reader.read()) != -1) {
                    if (fileSymbol != '\n') {
                        if (fileSymbol != original[i]) {
                            if (buffer.size() != 0) {
                                writeFromList(writer, buffer);
                                buffer.clear();
                            }
                            writer.write(fileSymbol);
                        } else {
                            buffer.add(fileSymbol);
                            i++;
                            if (i == original.length) {
                                writeFromList(writer, Arrays.stream(newString)
                                        .boxed().collect(Collectors.toList()));
                                buffer.clear();
                                i = 0;
                            }
                        }
                    }
                }
                //XXX code copy
                if (buffer.size() != 0) {
                    writeFromList(writer, buffer);
                    buffer.clear();
                }

                reader.close();
                writer.close();
                Files.copy(Paths.get(temp.getPath()), Paths.get(file.getPath()),
                        StandardCopyOption.REPLACE_EXISTING);
                IOUtilities.println("Replaced has been done.");
            } catch (IOException e) {
                e.printStackTrace();
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
}
