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
import java.util.ArrayList;
import java.util.List;

public class StatePersistence {
    File stateFile = new File("State.json");
    File solutionFile = new File("Solution.json");

    public void saveState(Words words) {
        JSONArray jsonArray = new JSONArray();
        
        for (int i = 1; i < words.getWords().size() +1; i++) {
            StringBuilder s = new StringBuilder();
            JSONObject fullWordDetails = new JSONObject();

            for (State state : words.getWordAt(i).getWordStates()) {
                switch (state) {
                    case CORRECT -> {
                        s.append("C");
                    }

                    case WRONG -> {
                        s.append("W");
                    }

                    case SEMI_CORRECT -> {
                        s.append("S");
                    }

                    case NOTHING -> {
                        s.append("N");
                    }

                }
            }
            fullWordDetails.put("state", s.toString());
            fullWordDetails.put("word", words.getWordAt(i).getWordVolumeAsString());
            JSONObject wordObject = new JSONObject();
            wordObject.put("fullWord", fullWordDetails);
            jsonArray.add(wordObject);
        }


        try (FileWriter file = new FileWriter(stateFile, false)) {
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveSolution(Solution solution) {
        JSONObject solutionAsJSON = new JSONObject();
        solutionAsJSON.put("word", (String) solution.getSolution());
        solutionAsJSON.put("date", solution.getDate().toString());

        try (FileWriter file = new FileWriter(solutionFile, false)) {
            file.write(solutionAsJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private FileWriter createSolutionFile() throws IOException {
        FileWriter writer;
        writer = new FileWriter(solutionFile, false);
        return writer;
    }

    public Solution loadSolution() {

        try {
            Object ob = new JSONParser().parse(new FileReader(solutionFile));
            JSONObject js = (JSONObject) ob;
            String solution = (String) js.get("word");
             LocalDate date = LocalDate.parse((String) js.get("date"));

            return new Solution(solution, date);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new Solution("VOGEL", LocalDate.now());
    }

    public void resetFile() {
        JSONArray jsonArray = new JSONArray();
        for (int i = 1; i < 7; i++) {
            JSONObject fullWordDetails = new JSONObject();

            fullWordDetails.put("state", "NNNNN");
            fullWordDetails.put("word", "_____");
            JSONObject wordObject = new JSONObject();
            wordObject.put("fullWord", fullWordDetails);
            jsonArray.add(wordObject);

        }

        try (FileWriter file = new FileWriter(stateFile, false)) {
            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private final List<Word> wordList = new ArrayList<>();

    public Words loadState() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(stateFile)) {
            Object obj = jsonParser.parse(reader);
            JSONArray wordsFromJSON = (JSONArray) obj;
            System.out.println(wordsFromJSON);
            wordsFromJSON.forEach(wfj -> parsWordObject((JSONObject) wfj));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        for (Word word : wordList) {
            System.out.println(word.toString());
        }
        return new Words(wordList);

    }

    private void parsWordObject(JSONObject word) {
        JSONObject wordObject = (JSONObject) word.get("fullWord");

        String wordFromJason = (String) wordObject.get("word");
        char[] wordAsArray = wordFromJason.toCharArray();

        String wordState = (String) wordObject.get("state");
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

        wordList.add(new Word(wordAsListOfLetter));


    }
}
