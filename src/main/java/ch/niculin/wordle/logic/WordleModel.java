package ch.niculin.wordle.logic;

import ch.niculin.wordle.persistence.StatePersistence;
import ch.niculin.wordle.persistence.WordListImporter;

import java.io.File;
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
        var word1 = wordChecker.checkUserWordInput(word);
        Word word2 = words.getWords().get(Position.getInstance().getRound() - 1);
        for (int i = 0; i < word2.getWordLetter().size(); i++){
            word2.getWordLetter().get(i).setState(word1.getWordStates().get(i));
        }
        return word1;
    }

    public void save() {
        statePersistence.saveState(words);
    }

    public boolean gameCanContinue() {
        return Position.getInstance().getRound() <= 6;
    }

    public boolean gameCanContinueForListener() {
        if (Position.getInstance().plusOneRound()) {
            Position.getInstance().resetPosition();
            return true;
        } else return false;
    }

    public boolean IsWordTheSolutionInverted(Word word) {
        return !wordChecker.checkSuccess(word);
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
        return wordList.contains(word.getWordAsString());
    }

    public List<String> getWordList() {
        return wordList;
    }

    public boolean isWinScreen() {
        return words.getWordsAsListOfStrings().contains(wordChecker.getSolution().getSolution());
    }

    public Words getWords() {
        return words;
    }
}
