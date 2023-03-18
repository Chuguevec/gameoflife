package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class OutputFileWriter {
    private static final String PREFIX = "src/test/resources/";

    public void write(char[][] chars, String path) {
        try (FileWriter writer = new FileWriter(PREFIX + path)) {
            for (char[] aChar : chars) {
                writer.write(charsToString(aChar));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String charsToString(char[] chars) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length - 1; i++) {
            builder.append(chars[i]).append(" ");
        }
        builder.append(chars[chars.length - 1]).append("\n");
        return builder.toString();
    }
}
