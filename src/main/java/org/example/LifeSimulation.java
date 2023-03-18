package org.example;

public class LifeSimulation {

    public char[][] run(char[][] field, int iterations) {
        char[][] newField = field;
        for (int i = 0; i < iterations; i++) {
            newField = lifeCycle(newField);
        }
        return newField;
    }

    private char[][] lifeCycle(char[][] field) {
        char[][] tempField = new char[field.length][field[0].length];
        for (int i = 0; i < tempField.length; i++) {
            for (int j = 0; j < tempField[i].length; j++) {
                int countLiveNeighbors = getCountLiveNeighbors(field, i, j);
                if (field[i][j] == 'X' && (countLiveNeighbors == 3 || countLiveNeighbors == 4)) {
                    tempField[i][j] = 'X';
                } else if (field[i][j] == 'O' && countLiveNeighbors == 3) {
                    tempField[i][j] = 'X';
                } else {
                    tempField[i][j] = 'O';
                }
            }
        }
        return tempField;
    }

    private int getCountLiveNeighbors(char[][] chars, int i, int j) {
        int count = 0;

        for (int i2 = i - 1; i2 <= i + 1; i2++) {
            for (int j2 = j - 1; j2 <= j + 1; j2++) {
                int tempJ = j2;
                int tempI = i2;
                if (i2 < 0) {
                    tempI = chars.length - 1;
                }
                if (i2 > chars.length - 1) {
                    tempI = 0;
                }
                if (j2 < 0) {
                    tempJ = chars[0].length - 1;
                }
                if (j2 > chars[0].length - 1) {
                    tempJ = 0;
                }
                if (chars[tempI][tempJ] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

}
