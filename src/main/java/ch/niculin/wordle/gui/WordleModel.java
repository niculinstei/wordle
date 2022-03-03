package ch.niculin.wordle.gui;

import ch.niculin.wordle.logic.WordCheckerImpl;

import java.util.*;

public class WordleModel {
    WordCheckerImpl wordChecker = new WordCheckerImpl();
    //TODO mit Word ersetzen?
    private final List<Letter> row1;
    private final List<Letter> row2;
    private final List<Letter> row3;
    private final List<Letter> row4;
    private final List<Letter> row5;
    private final List<Letter> row6;
    private final List<String> wordList;

    public WordleModel() {
        wordList = new ArrayList<>();
        wordList.add("VOGEL");
        wordList.add("QUIZZ");
        wordList.add("PIZZA");
        wordList.add("QUARZ");
        wordList.add("ZWECK");
        wordList.add("ZWICK");
        wordList.add("JUCKT");
        wordList.add("ABZUG");
        //TODO: mit forloop liste abfüllen
        Letter letter1_1 = new Letter("__", State.NOTHING);
        Letter letter1_2 = new Letter("__", State.NOTHING);
        Letter letter1_3 = new Letter("__", State.NOTHING);
        Letter letter1_4 = new Letter("__", State.NOTHING);
        Letter letter1_5 = new Letter("__", State.NOTHING);

        Letter letter2_1 = new Letter("__", State.NOTHING);
        Letter letter2_2 = new Letter("__", State.NOTHING);
        Letter letter2_3 = new Letter("__", State.NOTHING);
        Letter letter2_4 = new Letter("__", State.NOTHING);
        Letter letter2_5 = new Letter("__", State.NOTHING);

        Letter letter3_1 = new Letter("__", State.NOTHING);
        Letter letter3_2 = new Letter("__", State.NOTHING);
        Letter letter3_3 = new Letter("__", State.NOTHING);
        Letter letter3_4 = new Letter("__", State.NOTHING);
        Letter letter3_5 = new Letter("__", State.NOTHING);

        Letter letter4_1 = new Letter("__", State.NOTHING);
        Letter letter4_2 = new Letter("__", State.NOTHING);
        Letter letter4_3 = new Letter("__", State.NOTHING);
        Letter letter4_4 = new Letter("__", State.NOTHING);
        Letter letter4_5 = new Letter("__", State.NOTHING);

        Letter letter5_1 = new Letter("__", State.NOTHING);
        Letter letter5_2 = new Letter("__", State.NOTHING);
        Letter letter5_3 = new Letter("__", State.NOTHING);
        Letter letter5_4 = new Letter("__", State.NOTHING);
        Letter letter5_5 = new Letter("__", State.NOTHING);

        Letter letter6_1 = new Letter("__", State.NOTHING);
        Letter letter6_2 = new Letter("__", State.NOTHING);
        Letter letter6_3 = new Letter("__", State.NOTHING);
        Letter letter6_4 = new Letter("__", State.NOTHING);
        Letter letter6_5 = new Letter("__", State.NOTHING);

        row1 = List.of(letter1_1, letter1_2, letter1_3, letter1_4, letter1_5);
        row2 = List.of(letter2_1, letter2_2, letter2_3, letter2_4, letter2_5);
        row3 = List.of(letter3_1, letter3_2, letter3_3, letter3_4, letter3_5);
        row4 = List.of(letter4_1, letter4_2, letter4_3, letter4_4, letter4_5);
        row5 = List.of(letter5_1, letter5_2, letter5_3, letter5_4, letter5_5);
        row6 = List.of(letter6_1, letter6_2, letter6_3, letter6_4, letter6_5);
    }

    public Letter setNextLetter(String letterToFill) {
        Letter letterToReturn = getCurrentLetter();
        letterToReturn.setLetter(letterToFill);
        Position.getInstance().moveForward();
        return letterToReturn;
    }

    //TODO: braucht es setState?, code teilen mit removeALL
    public Letter deleteCurrentLetter() {
        Letter letterToReturn = getCurrentLetter();
        letterToReturn.setLetter("__");
        letterToReturn.setState(State.NOTHING);
        Position.getInstance().moveBackward();
        return letterToReturn;
    }

    public Word removeAllLettersOfCurrentRow() {
        for (Letter letter : getCurrentRow()) {
            letter.setLetter("__");
        }
        return new Word(getCurrentRow());
    }

    private Letter getCurrentLetter() {
        return switch (Position.getInstance().getRound()) {
            case 1 -> row1.get(Position.getInstance().getNextPosition());
            case 2 -> row2.get(Position.getInstance().getNextPosition());
            case 3 -> row3.get(Position.getInstance().getNextPosition());
            case 4 -> row4.get(Position.getInstance().getNextPosition());
            case 5 -> row5.get(Position.getInstance().getNextPosition());
            case 6 -> row6.get(Position.getInstance().getNextPosition());
            default -> new Letter("__", State.NOTHING);
        };
    }

    private List<Letter> getCurrentRow() {
        return switch (Position.getInstance().getRound()) {
            case 1 -> row1;
            case 2 -> row2;
            case 3 -> row3;
            case 4 -> row4;
            case 5 -> row5;
            case 6 -> row6;
            default -> new ArrayList<>();
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

    public Word rateCurrentWord(Word word) {
        wordChecker.checkUserWordInput(word);
        return word;
    }

    public boolean gameCanContinue() {
        if (Position.getInstance().plusOneRound()) {
            Position.getInstance().resetPosition();
            return true;
        } else {
            return false;
        }
    }
}
