package ch.niculin.wordle.logic;

import ch.niculin.wordle.gui.Letter;
import ch.niculin.wordle.gui.State;
import ch.niculin.wordle.gui.Word;
import ch.niculin.wordle.gui.WordChecker;

import java.util.List;

public class WordCheckerImpl implements WordChecker {
    String solution = "PIZZA";
    List<String> solutionAsListOfString = List.of("P", "I", "Z", "Z", "A");
    String wordAsString;


    @Override
    public Word checkUserWordInput(Word word) {
        List<String> wordAsListOfStrings = word.getWordVolume();
        wordAsString = wordAsListOfStrings.toString();


        if (wordAsString.equals(solution)) {
            return returnSuccess(word);
        }

        for (Letter letter : word.getWord()) {
            letter.setState(State.WRONG);
        }

        for (int i = 0; i < wordAsListOfStrings.size(); i++) {
             if (wordAsListOfStrings.get(i).equals(solutionAsListOfString.get(i))) {
                word.getWord().get(i).setState(State.CORRECT);
                continue;
            }

             if (solutionAsListOfString.contains(wordAsListOfStrings.get(i)))
                word.getWord().get(i).setState(State.SEMI_CORRECT);
            }

        return word;
    }

    private Word returnSuccess(Word word) {
        for(Letter letter: word.getWord()){
            letter.setState(State.CORRECT);
        }
        return word;
    }
}


