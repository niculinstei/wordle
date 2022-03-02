package ch.niculin.wordle.gui;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private final List<Letter> word;
    private State state;

    public Word (Letter l1, Letter l2, Letter l3, Letter l4, Letter l5){
        word = List.of(l1, l2, l3, l4, l5);
    }
    public Word(List<Letter> letter){
        this.word = letter;
        this.state = State.NOTHING;
    }

    public Word(String word){
        List<Letter> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            String string = Character.toString(currentChar);
            list.add(new Letter(string, State.NOTHING));
        }
        this.word = List.copyOf(list);
        this.state = State.NOTHING;
    }

    public List<String> getWordVolume() {
        return List.of(
                word.get(0).getVolume(),
                word.get(1).getVolume(),
                word.get(2).getVolume(),
                word.get(3).getVolume(),
                word.get(4).getVolume());
    }
    public List<Letter> getWord(){
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

    public String getWordVolumeAsString() {
        String wordVolume = String.join("", getWordVolume());
        return wordVolume;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

