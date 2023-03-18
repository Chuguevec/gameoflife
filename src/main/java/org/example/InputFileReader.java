package org.example;

import java.io.FileReader;
import java.io.IOException;


public class InputFileReader {
    private static final String PREFIX = "src/test/resources/";
    private int width;
    private int height;
    private Integer iterations;
    private char[][] charsField;

    public InputFileReader(String pathInputFile) {
        readFile(pathInputFile);
    }

    private void readFile(String path) {
        try (FileReader fileReader = new FileReader(PREFIX + path)) {
            int countParam = 3;
            int currentParam = 1;
            StringBuilder builder = new StringBuilder();
            while (fileReader.ready() && currentParam <= countParam) {
                char value = (char) fileReader.read();
                if (Character.isDigit(value)) {
                    builder.append(value);
                } else {
                    setParam(builder.toString(), currentParam);
                    builder.setLength(0);
                    currentParam++;
                }
            }
            charsField = new char[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    while (fileReader.ready()) {
                        char value = (char) fileReader.read();
                        if (Character.isLetterOrDigit(value)) {
                            charsField[i][j] = value;
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setParam(String value, int currentParam) {
        switch (currentParam) {
            case 1 -> height = Integer.parseInt(value);
            case 2 -> width = Integer.parseInt(value);
            case 3 -> iterations = Integer.parseInt(value);
        }
    }

    public int getIterations() {
        return iterations;
    }

    public char[][] getCharsField() {
        return charsField;
    }
}
