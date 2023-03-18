package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class OutputFileWriter {
    private static final String PREFIX = "src/test/resources/";

    public void write(char[][] field, String path) {
        try (FileWriter writer = new FileWriter(PREFIX + path)) {
            for (char[] filedLine : field) {
                writer.write(charsToString(filedLine));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //получаем строку нужного формата из одного массива символов двумерного массива
    public String charsToString(char[] filedLine) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < filedLine.length - 1; i++) {
            builder.append(filedLine[i]).append(" ");
        }
        builder.append(filedLine[filedLine.length - 1]).append("\n");
        return builder.toString();
    }
}
