package org.example;


public class GameOfLife {
    public static void main(String[] args) {
        String input = "inputOscillator2.txt";
        String output = "outputOscillator2.txt";
        GameOfLife game = new GameOfLife();
        game.game(input, output);
    }

    public void game(String input, String output) {
        //считываем файл
        InputFileReader fieldReader = new InputFileReader(input);
        char[][] inputField = fieldReader.getCharsField();
        int iterations = fieldReader.getIterations();
        //запускаем обработку
        LifeSimulation lifeSimulation = new LifeSimulation();
        char[][] result = lifeSimulation.run(inputField, iterations);
        //записываем результат
        OutputFileWriter writer = new OutputFileWriter();
        writer.write(result, output);
    }
}
