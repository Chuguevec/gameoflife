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
        char[][] newField = new char[field.length][field[0].length];
        for (int i = 0; i < newField.length; i++) {
            for (int j = 0; j < newField[i].length; j++) {
                int countLiveNeighbors = getCountLiveNeighbors(field, i, j);
                if ((isAlive(field[i][j]) && countLiveNeighbors == 4) || countLiveNeighbors == 3) {
                    newField[i][j] = 'X';
                } else {
                    newField[i][j] = 'O';
                }
            }
        }
        return newField;
    }

    private int getCountLiveNeighbors(char[][] field, int positionByX, int positionByY) {
        int countNeighbors = 0;

        for (int x = positionByX - 1; x <= positionByX + 1; x++) {
            for (int y = positionByY - 1; y <= positionByY + 1; y++) {
                int positionX = x;
                int positionY = y;
                if (x < 0) {
                    positionX = field.length - 1;
                }
                if (x > field.length - 1) {
                    positionX = 0;
                }
                if (y < 0) {
                    positionY = field[0].length - 1;
                }
                if (y > field[0].length - 1) {
                    positionY = 0;
                }
                if (isAlive(field[positionX][positionY])) {
                    countNeighbors++;
                }
            }
        }
        return countNeighbors;
    }

    private boolean isAlive(char value) {
        return value == 'X';
    }

}
