package org.example;

import java.io.FileReader;
import java.io.IOException;


public class InputFileReader {
    private String path;
    private int width;
    private int height;
    private Integer iterations;
    private char [][] charsField;

    public InputFileReader(String pathInputFile) {
        path = pathInputFile;
        readFile();
    }

    private void readFile() {
        try (FileReader fileReader = new FileReader(path)) {
            int countParam = 3;
            int currentParam = 1;
            StringBuilder builder = new StringBuilder();
            while (fileReader.ready() && currentParam <= countParam) {
                char value = (char) fileReader.read();
                if (Character.isDigit(value)) {
                    builder.append(value);
                }else {
                    setParam(builder, currentParam);
                    currentParam++;
                }
            }
            charsField = new char[width][height];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    while (fileReader.ready()){
                        char value = (char) fileReader.read();
                        if (Character.isLetterOrDigit(value)){
                            charsField[i][j] = value;
                            break;
                        }
                    }

                }

            }
            System.out.println("width = " + width);
            System.out.println("height = " + height);
            System.out.println("iterations = " + iterations);
            printArray(charsField);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void setParam(StringBuilder builder, int currentParam) {
        switch (currentParam) {
            case 1 -> {
                height = Integer.parseInt(builder.toString());
                builder.setLength(0);
            }
            case 2 -> {
                width = Integer.parseInt(builder.toString());
                builder.setLength(0);
            }
            case 3 -> {
                iterations = Integer.parseInt(builder.toString());
                builder.setLength(0);
            }
        }
    }

    public void printArray(char[][] chars){
        for (char[] aChar : chars) {
            for (char c : aChar) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public int getIterations() {
        return iterations;
    }

    public char[][] getCharsField() {
        return charsField;
    }
}
