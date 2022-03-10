package ch.niculin.wordle.persistence;

import ch.niculin.wordle.logic.Word;
import ch.niculin.wordle.logic.Words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StatePersistence {
    File file = new File("state.txt");
    File solutionFile = new File("solution.txt");

    public void saveState(Words words) {
        FileWriter writer;
        try {
            writer = new FileWriter(file, false);
            for (Word word : words.getWords()) {
                writer.write(word.getWordVolumeAsString());
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveSolution(String solution) {
        FileWriter writer;
        try {
            writer = new FileWriter(solutionFile, false);
            writer.write(solution);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadSolution() {
        String solution = null;
        try {
            Scanner scanner = new Scanner(solutionFile);
            solution = scanner.nextLine().toUpperCase(Locale.ROOT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return solution;
    }

    public void resetFile() {
        FileWriter writer;
        try {
            writer = new FileWriter(file, false);
            for (int i = 1; i < 7; i++) {
                writer.write("_____");
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Words loadState() {
        List<Word> wordList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                wordList.add(new Word(scanner.nextLine().toUpperCase(Locale.ROOT)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new Words(wordList);
    }
}
