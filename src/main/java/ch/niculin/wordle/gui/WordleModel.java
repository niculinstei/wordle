package ch.niculin.wordle.gui;

import ch.niculin.wordle.logic.WordCheckerImpl;

import java.util.*;

public class WordleModel {
    WordCheckerImpl wordChecker = new WordCheckerImpl();
    private final List<Letter> row1;
    private final List<Letter> row2;
    private final List<Letter> row3;
    private final List<Letter> row4;
    private final List<Letter> row5;
    private final List<Letter> row6;
    private final List<String>  wordList;

    private final Letter letter1_1;
    private final Letter letter1_2;
    private final Letter letter1_3;
    private final Letter letter1_4;
    private final Letter letter1_5;

    private final Letter letter2_1;
    private final Letter letter2_2;
    private final Letter letter2_3;
    private final Letter letter2_4;
    private final Letter letter2_5;

    private final Letter letter3_1;
    private final Letter letter3_2;
    private final Letter letter3_3;
    private final Letter letter3_4;
    private final Letter letter3_5;

    private final Letter letter4_1;
    private final Letter letter4_2;
    private final Letter letter4_3;
    private final Letter letter4_4;
    private final Letter letter4_5;

    private final Letter letter5_1;
    private final Letter letter5_2;
    private final Letter letter5_3;
    private final Letter letter5_4;
    private final Letter letter5_5;

    private final Letter letter6_1;
    private final Letter letter6_2;
    private final Letter letter6_3;
    private final Letter letter6_4;
    private final Letter letter6_5;

;

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


         letter1_1 = new Letter("__", State.NOTHING);
         letter1_2 = new Letter("__", State.NOTHING);
         letter1_3 = new Letter("__", State.NOTHING);
         letter1_4 = new Letter("__", State.NOTHING);
         letter1_5 = new Letter("__", State.NOTHING);

         letter2_1 = new Letter("__", State.NOTHING);
         letter2_2 = new Letter("__", State.NOTHING);
         letter2_3 = new Letter("__", State.NOTHING);
         letter2_4 = new Letter("__", State.NOTHING);
         letter2_5 = new Letter("__", State.NOTHING);

         letter3_1 = new Letter("__", State.NOTHING);
         letter3_2 = new Letter("__", State.NOTHING);
         letter3_3 = new Letter("__", State.NOTHING);
         letter3_4 = new Letter("__", State.NOTHING);
         letter3_5 = new Letter("__", State.NOTHING);

         letter4_1 = new Letter("__", State.NOTHING);
         letter4_2 = new Letter("__", State.NOTHING);
         letter4_3 = new Letter("__", State.NOTHING);
         letter4_4 = new Letter("__", State.NOTHING);
         letter4_5 = new Letter("__", State.NOTHING);

         letter5_1 = new Letter("__", State.NOTHING);
         letter5_2 = new Letter("__", State.NOTHING);
         letter5_3 = new Letter("__", State.NOTHING);
         letter5_4 = new Letter("__", State.NOTHING);
         letter5_5 = new Letter("__", State.NOTHING);

         letter6_1 = new Letter("__", State.NOTHING);
         letter6_2 = new Letter("__", State.NOTHING);
         letter6_3 = new Letter("__", State.NOTHING);
         letter6_4 = new Letter("__", State.NOTHING);
         letter6_5 = new Letter("__", State.NOTHING);

        row1 = List.of(letter1_1, letter1_2, letter1_3, letter1_4, letter1_5);
        row2 = List.of(letter2_1, letter2_2, letter2_3, letter2_4, letter2_5);
        row3 = List.of(letter3_1, letter3_2, letter3_3, letter3_4, letter3_5);
        row4 = List.of(letter4_1, letter4_2, letter4_3, letter4_4, letter4_5);
        row5 = List.of(letter5_1, letter5_2, letter5_3, letter5_4, letter5_5);
        row6 = List.of(letter6_1, letter6_2, letter6_3, letter6_4, letter6_5);
    }

    public Word removeAll(){
         Word word;
         for (Letter letter : getCurrentRow()){
             letter.setVolume("__");
         }
         return word = new Word(getCurrentRow());
    }

    public Letter setNextLetter(String letterToFill){
        Letter letterToReturn = getCurrentLetter();
        letterToReturn.setVolume(letterToFill);
        Position.getInstance().moveForward();

        return letterToReturn ;
    }

    public Letter deleteCurrentLetter() {
        Letter letterToReturn = getCurrentLetter();
               letterToReturn .setVolume("__");
               letterToReturn.setState(State.NOTHING);
               Position.getInstance().moveBackward();
        return letterToReturn;
    }


    private Letter getCurrentLetter(){
         switch (Position.getInstance().getRound()){
             case 1: return row1.get(Position.getInstance().getNextPosition());
             case 2: return row2.get(Position.getInstance().getNextPosition());
             case 3: return row3.get(Position.getInstance().getNextPosition());
             case 4: return row4.get(Position.getInstance().getNextPosition());
             case 5: return row5.get(Position.getInstance().getNextPosition());
             case 6: return row6.get(Position.getInstance().getNextPosition());
             default: return new Letter("__", State.NOTHING);
         }
    }

    private List<Letter> getCurrentRow(){
        switch (Position.getInstance().getRound()){
            case 1: return row1;
            case 2: return row2;
            case 3: return row3;
            case 4: return row4;
            case 5: return row5;
            case 6: return row6;
            default: return new ArrayList<>();
        }
    }

    public Word validateCurrentWord(Word word){
         wordChecker.checkUserWordInput(word);
         return word;
    }

    public boolean wordIsValid(Word word) {
        for (String letter : word.getWordVolume()){
            if (letter.equals("__"))
                return false;
        }
        if (!wordList.contains(word.getWordVolumeAsString())){
            return false;
        }
        return true;
    }

    public boolean gameCanContinue() {
         if (Position.getInstance().plusOneRound()){
             Position.getInstance().resetPosition();
             return true;
         } else {
             return false;
         }

    }
}
