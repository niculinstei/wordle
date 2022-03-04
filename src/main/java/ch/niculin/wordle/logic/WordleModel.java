package ch.niculin.wordle.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class WordleModel {

    private final Word row1;
    private final Word row2;
    private final Word row3;
    private final Word row4;
    private final Word row5;
    private final Word row6;
    private final List<String> wordList;
    WordCheckerImpl wordChecker;


    public WordleModel() {
        wordList = new ArrayList<>();

        File file = new File("list.txt");
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
        wordChecker = new WordCheckerImpl(wordList);

        row1 = fillList();
        row2 = fillList();
        row3 = fillList();
        row4 = fillList();
        row5 = fillList();
        row6 = fillList();
    }

    private Word fillList() {
        List<Letter> letterList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            letterList.add(new Letter("__", State.NOTHING));
        }
        return new Word(letterList);
    }

    public Letter setNextLetter(String letterToFill) {
        Letter letterToReturn = getCurrentLetter();
        letterToReturn.setLetter(letterToFill);
        Position.getInstance().moveForward();
        return letterToReturn;
    }

    public Letter deleteCurrentLetter() {
        Letter letterToReturn = getCurrentLetter();
        letterToReturn.setLetter("__");
        Position.getInstance().moveBackward();
        return letterToReturn;
    }

    public Word removeAllLettersOfCurrentRow() {
        for (Letter letter : getCurrentRow().getWordLetter()) {
            letter.setLetter(deleteCurrentLetter().getLetter());
        }
        return new Word(getCurrentRow().getWordLetter());
    }

    public Word rateCurrentWord(Word word) {
        wordChecker.checkUserWordInput(word);
        return word;
    }

    public boolean gameCanContinue() {
        if (!Position.getInstance().plusOneRound()) {
            return true;
        } else {
            Position.getInstance().resetPosition();
            return false;

        }
    }

    public boolean IsWordTheSolution(Word word) {
        if (wordChecker.checkSuccess(word)) {
            return true;
        } else {
            return false;
        }

    }

    public List<String> getWordList() {
        return wordList;
    }


    private Letter getCurrentLetter() {
        return switch (Position.getInstance().getRound()) {
            case 1 -> row1.getWordLetter().get(Position.getInstance().getNextPosition());
            case 2 -> row2.getWordLetter().get(Position.getInstance().getNextPosition());
            case 3 -> row3.getWordLetter().get(Position.getInstance().getNextPosition());
            case 4 -> row4.getWordLetter().get(Position.getInstance().getNextPosition());
            case 5 -> row5.getWordLetter().get(Position.getInstance().getNextPosition());
            case 6 -> row6.getWordLetter().get(Position.getInstance().getNextPosition());
            default -> new Letter("__", State.NOTHING);
        };
    }

    private Word getCurrentRow() {
        return switch (Position.getInstance().getRound()) {
            case 1 -> row1;
            case 2 -> row2;
            case 3 -> row3;
            case 4 -> row4;
            case 5 -> row5;
            case 6 -> row6;
            default -> new Word(" ");
        };
    }

    public boolean wordIsValid(Word word) {
        return validateWord(word) && validateWordIsInList(word);
    }

    private boolean validateWord(Word word) {
        for (Letter letter : word.getWordLetter()) {
            if (!letter.isValid()) {
                return false;
            }
        }
        return true;
    }

    private boolean validateWordIsInList(Word word) {
        return wordList.contains(word.getWordVolumeAsString());
    }
}
