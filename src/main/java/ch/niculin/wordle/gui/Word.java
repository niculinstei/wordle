package ch.niculin.wordle.gui;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private final List<Letter> word;

    public Word(Letter l1, Letter l2, Letter l3, Letter l4, Letter l5) {
        word = List.of(l1, l2, l3, l4, l5);
    }

    public Word(List<Letter> letter) {
        this.word = letter;
    }

    public Word(String word) {
        List<Letter> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            String string = Character.toString(currentChar);
            list.add(new Letter(string, State.NOTHING));
        }
        this.word = List.copyOf(list);
    }

    public List<String> getWordVolume() {
        return List.of(
                word.get(0).getLetter(),
                word.get(1).getLetter(),
                word.get(2).getLetter(),
                word.get(3).getLetter(),
                word.get(4).getLetter());
    }

    public List<Letter> getWordLetter() {
        return List.of(
                word.get(0),
                word.get(1),
                word.get(2),
                word.get(3),
                word.get(4));
    }

    public List<Letter> getWord() {
        return word;
    }

    public List<State> getWordStates() {
        return List.of(
                word.get(0).getState(),
                word.get(1).getState(),
                word.get(2).getState(),
                word.get(3).getState(),
                word.get(4).getState());
    }

    public boolean isWordTheWinningWord() {
        return !getWordStates().contains(State.WRONG) && !getWordStates().contains(State.SEMI_CORRECT) && !getWordStates().contains(State.NOTHING);
    }

    public String getWordVolumeAsString() {
        return String.join("", getWordVolume());
    }

    public boolean isWordValid() {
/*        for (Letter letter : word) {
            if (!letter.isValid()) {
                return false;
            }
        }
        return true;*/

        return word.stream().allMatch(Letter::isValid);
    }
}

