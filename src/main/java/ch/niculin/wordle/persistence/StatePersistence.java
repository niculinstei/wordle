package ch.niculin.wordle.persistence;

import ch.niculin.wordle.logic.Solution;
import ch.niculin.wordle.logic.Word;
import ch.niculin.wordle.logic.Words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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

    public void saveSolution(Solution solution) {

        try {

            FileWriter writer = createSolutionFile();
            writer.write(solution.getSolution());
            writer.write(System.getProperty("line.separator"));
            writer.write(solution.getDate().toString());
            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private FileWriter createSolutionFile() throws IOException {
        FileWriter writer;
        writer = new FileWriter(solutionFile, false);
        return writer;
    }

    public Solution loadSolution() {
        List<String> strings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(solutionFile);
            while (scanner.hasNextLine()){
                strings.add(scanner.nextLine());
            }
            if (strings.size() == 2){
                return new Solution(strings.get(0), LocalDate.parse(strings.get(1)));
            } else if (strings.size() == 3){
                return new Solution("!!!", LocalDate.now());
            } else {
                return new Solution("VOGEL", LocalDate.now());
            }
        } catch (FileNotFoundException e) {
            try {
                createSolutionFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }
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

    public void WordIsCorrect (String s, LocalDate date) {
        try {
            FileWriter writer = new FileWriter(solutionFile, false);
            writer.write(s);
            writer.write(System.getProperty("line.separator"));
            writer.write(date.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
