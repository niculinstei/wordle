package ch.niculin.wordle.logic;

import ch.niculin.wordle.persistence.StatePersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordCheckerImpl implements WordChecker {
    private String solution;
    private List<String> solutionAsListOfString;
    private String wordAsString;

    public WordCheckerImpl(List<String> wordList){
        Random ran = new Random();
        int counter = 0;
        for (Word word : new StatePersistence().loadState().getWords()){
            if (word.isWordValid()){
                counter++;
            }
        }
        if (counter == 0){
            solution = wordList.get(ran.nextInt(wordList.size()));
            new StatePersistence().saveSolution(solution);
        } else {
            solution = new StatePersistence().loadSolution();
        }

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

    public boolean checkSuccess(Word word) {
        return word.getWordVolumeAsString().equals(solution);
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

    public String getSolution() {
        return solution;
    }

    public List<String> getSolutionAsListOfString() {
        return solutionAsListOfString;
    }

    public String getWordAsString() {
        return wordAsString;
    }
}


