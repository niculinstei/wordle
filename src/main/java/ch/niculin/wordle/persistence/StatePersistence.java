package ch.niculin.wordle.persistence;

import ch.niculin.wordle.logic.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class StatePersistence {
    public static final String FULL_WORD = "fullWord";
    public static final String WORD = "word";
    public static final String STATE = "state";
    public static final String DATE = "date";


    File stateFile = new File("State.json");
    File solutionFile = new File("Solution.json");

    public void saveState(Words words) {
        JSONArray jsonArray = new JSONArray();

        for (Word word : words.getWords()) {
            Map<String, String> wordInfo = new HashMap<>();
            String state = statePerLetter(word);
            wordInfo.put(STATE, state);
            wordInfo.put(WORD, word.getWordAsString());
            Map<String, Map<String, String>> fullWordInfo = new HashMap<>();
            fullWordInfo.put(FULL_WORD, wordInfo);
            jsonArray.add(fullWordInfo);
        }

        write(jsonArray.toJSONString(), stateFile);
    }

    private String statePerLetter(Word word) {
        StringBuilder s = new StringBuilder();
        for (Letter letter : word.getWordLetter()) {
            switch (letter.getState()) {
                case CORRECT -> s.append("C");
                case WRONG -> s.append("W");
                case SEMI_CORRECT -> s.append("S");
                case NOTHING -> s.append("N");
            }
        }
        return s.toString();
    }

    public void saveSolution(Solution solution) {
        JSONObject solutionAsJSON = new JSONObject();
        solutionAsJSON.put(WORD, solution.getSolution());
        solutionAsJSON.put(DATE, solution.getDate().toString());
        write(solutionAsJSON.toJSONString(), solutionFile);
    }

    public Solution loadSolution(List<String> wordList) {

        try {
            JSONObject ob = (JSONObject) new JSONParser().parse(new FileReader(solutionFile));
            String solution = (String) ob.get(WORD);
            LocalDate date = LocalDate.parse((String) ob.get(DATE));

            return new Solution(solution, date);
        } catch (Exception e) {
            Random ran = new Random();
            LocalDate dateOfSolution = LocalDate.now();
            String solutionWord = wordList.get(ran.nextInt(wordList.size()));
            Solution solution = new Solution(solutionWord, dateOfSolution);
            saveSolution(solution);
            return solution;
        }
    }

    public void resetFile() {
        JSONArray jsonArray = new JSONArray();
        for (int i = 1; i < 7; i++) {
            JSONObject fullWordDetails = new JSONObject();

            fullWordDetails.put(STATE, "NNNNN");
            fullWordDetails.put(WORD, "_____");
            JSONObject wordObject = new JSONObject();
            wordObject.put(FULL_WORD, fullWordDetails);
            jsonArray.add(wordObject);

        }
        write(jsonArray.toJSONString(), stateFile);
    }


    private void write(String jsonArray, File fileToWrite) {
        try (FileWriter file = new FileWriter(fileToWrite, false)) {
            file.write(jsonArray);
            file.flush();

        } catch (IOException e) {
            if (fileToWrite == stateFile) {
                resetFile();
            } else {
                e.printStackTrace();
            }
        }
    }

    public Words loadState() {
        List<Word> wordList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(stateFile)) {
            Object obj = jsonParser.parse(reader);
            JSONArray wordsFromJSON = (JSONArray) obj;
            for (Object object : wordsFromJSON) {
                wordList.add(parsWordObject((JSONObject) object));
            }

        } catch (IOException | ParseException e) {
            resetFile();
            for (int i = 1; i < 7; i++){
                wordList.add(new Word("_____"));
            }
        }
        return new Words(wordList);
    }

    private Word parsWordObject(JSONObject word) {
        JSONObject wordObject = (JSONObject) word.get(FULL_WORD);
        String wordFromJason = (String) wordObject.get(WORD);
        char[] wordAsArray = wordFromJason.toCharArray();

        String wordState = (String) wordObject.get(STATE);
        char[] stateAsArray = wordState.toCharArray();

        List<Letter> wordAsListOfLetter = new ArrayList<>();

        for (int i = 0; i < stateAsArray.length; i++) {
            Letter letter;
            String s = Character.toString(wordAsArray[i]);
            switch (stateAsArray[i]) {
                case 'C' -> {
                    letter = new Letter(s, State.CORRECT);
                    wordAsListOfLetter.add(letter);
                }
                case 'W' -> {
                    letter = new Letter(s, State.WRONG);
                    wordAsListOfLetter.add(letter);
                }
                case 'S' -> {
                    letter = new Letter(s, State.SEMI_CORRECT);
                    wordAsListOfLetter.add(letter);
                }
                case 'N' -> {
                    letter = new Letter(s, State.NOTHING);
                    wordAsListOfLetter.add(letter);
                }
            }
        }
        return (new Word(wordAsListOfLetter));
    }
}
