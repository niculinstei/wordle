package ch.niculin.wordle.logic;

import ch.niculin.wordle.persistence.StatePersistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordCheckerImpl implements WordChecker {
    private final Solution solution;
    private final List<String> solutionAsListOfString;

    public WordCheckerImpl(List<String> wordList) {
        Random ran = new Random();
        LocalDate dateOfSolution = new StatePersistence().loadSolution(wordList).getDate();
        if (LocalDate.now().isAfter(dateOfSolution)) {
            String solutionWord = wordList.get(ran.nextInt(wordList.size()));
            solution = new  Solution(solutionWord, LocalDate.now());
            new StatePersistence().saveSolution(solution);
            new StatePersistence().resetFile();
        } else {
            solution = new StatePersistence().loadSolution(wordList);
        }
        solutionAsListOfString = getSolutionAsListOfStrings(solution.getSolution());
        System.out.println(solution);
    }

    @Override
    public Word checkUserWordInput(Word word) {
        List<String> wordAsListOfStrings = word.getWordVolume();
        String wordAsString = wordAsListOfStrings.toString();
        if (wordAsString.equals(solution.getSolution())) {
            solution.setSolution("!!");
            new StatePersistence().saveSolution(solution);
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
            if (solutionAsListOfString.contains(wordAsListOfStrings.get(i))){
                word.getWord().get(i).setState(State.SEMI_CORRECT);
            }
            if (word.getWord().get(i).getLetter().equals("_")){
                word.getWord().get(i).setState(State.NOTHING);
            }
        }
        return word;
    }

    private Word returnSuccess(Word word) {
        for (Letter letter : word.getWord()) {
            letter.setState(State.CORRECT);
        }
        return word;
    }

    public boolean checkSuccess(Word word) {
        return word.getWordAsString().equals(solution.getSolution());
    }

    private List<String> getSolutionAsListOfStrings(String string) {
        List<String> listTOReturn = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            char c = (string.charAt(i));
            String s = Character.toString(c);
            listTOReturn.add(s);
        }
        return listTOReturn;
    }

    public Solution getSolution() {
        return solution;
    }
}


