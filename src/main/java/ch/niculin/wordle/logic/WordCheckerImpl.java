package ch.niculin.wordle.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordCheckerImpl implements WordChecker {
    String solution;
    List<String> solutionAsListOfString;
    String wordAsString;

    public WordCheckerImpl(List<String> wordList){
        Random ran = new Random();
        solution = wordList.get(ran.nextInt(wordList.size()));
        solutionAsListOfString = getSolutionAsListOfStrings(solution);
        System.out.println(solution);
    }

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

    private List<String> getSolutionAsListOfStrings (String string){
        List<String> listTOReturn = new ArrayList<>();
        for (int i = 0; i < string.length(); i++){
            char c = (string.charAt(i));
            String s = Character.toString(c);
            listTOReturn.add(s);
        }
        return listTOReturn;
    }
}


