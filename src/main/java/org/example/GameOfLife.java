package org.example;

public class GameOfLife {
    public static void main(String[] args) {
        String path = "src/test/resources/inputGlider.txt";
        InputFileReader fieldReader = new InputFileReader(path);
        char[][] inputField = fieldReader.getCharsField();
        int iterations = fieldReader.getIterations();
        LifeSimulation lifeSimulation = new LifeSimulation();
        char[][] chars = lifeSimulation.run(inputField, iterations);


    }
 
}
