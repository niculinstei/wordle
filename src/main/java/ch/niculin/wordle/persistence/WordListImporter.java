package ch.niculin.wordle.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class WordListImporter {
    public List<String> getWordListFromFile(File file) {
        return getWordList(file);
    }

    private List<String> getWordList(File file) {
        List<String> wordList = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(true) {
            assert scanner != null;
            if (!scanner.hasNext()) break;
            wordList.add(scanner.nextLine().toUpperCase(Locale.ROOT));
        }
        return wordList;
    }
}
