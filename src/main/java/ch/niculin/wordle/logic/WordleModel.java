package ch.niculin.wordle.logic;

import ch.niculin.wordle.persistence.StatePersistence;
import ch.niculin.wordle.persistence.WordListImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WordleModel {
    private final Words words;
    private final List<String> wordList;
    WordCheckerImpl wordChecker;
    StatePersistence statePersistence = new StatePersistence();


    public WordleModel() {
        File file = new File("list.txt");
        wordList = new WordListImporter().getWordListFromFile(file);
        wordChecker = new WordCheckerImpl(wordList);
        this.words = new StatePersistence().loadState();
    }

    public Word getRow1() {
        return rateCurrentWord(words.getWordAt(1));
    }

    public Word getRow2() {
        return rateCurrentWord(words.getWordAt(2));
    }

    public Word getRow3() {
        return rateCurrentWord(words.getWordAt(3));
    }

    public Word getRow4() {
        return rateCurrentWord(words.getWordAt(4));
    }

    public Word getRow5() {
        return rateCurrentWord(words.getWordAt(5));
    }

    public Word getRow6() {
        return rateCurrentWord(words.getWordAt(6));
    }

    public List<Word> getRowsToColour() {
        List<Word> rowsToColour = new ArrayList<>();
        for (Word word : words.getWords()){
            if (word.isWordValid()){
                rowsToColour.add(word);
            }
        }
        return rowsToColour;
    }

    public Letter setNextLetter(String letterToFill) {
        Letter letterToReturn = getCurrentLetter();
        letterToReturn.setLetter(letterToFill);
        Position.getInstance().moveForward();
        return letterToReturn;
    }

    public Letter deleteCurrentLetter() {
        Letter letterToReturn = getCurrentLetter();
        letterToReturn.setLetter("_");
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
        statePersistence.saveState(words);
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

    private Letter getCurrentLetter() {
        Word word = getCurrentRow();
        return word.getWordLetter().get(Position.getInstance().getNextPosition());
    }

    private Word getCurrentRow() {
        return words.getWordAt(Position.getInstance().getRound());
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
