package ch.niculin.wordle.logic;

import java.util.List;

public class Words {
    private final Word word1;
    private final Word word2;
    private final Word word3;
    private final Word word4;
    private final Word word5;
    private final Word word6;

    public Words(List<Word> words) {
        this.word1 = words.get(0);
        this.word2 = words.get(1);
        this.word3 = words.get(2);
        this.word4 = words.get(3);
        this.word5 = words.get(4);
        this.word6 = words.get(5);
    }

    public List<Word> getWords() {
        return List.of(word1, word2, word3, word4, word5, word6);
    }

    public List<String> getWordsAsListOfStrings() {
        return List.of(word1.getWordAsString(), word2.getWordAsString(),word3.getWordAsString(),word4.getWordAsString(),word5.getWordAsString(),word6.getWordAsString());
    }

    public Word getWordAt(int position) {
        return switch (position) {
            case 1 -> word1;
            case 2 -> word2;
            case 3 -> word3;
            case 4 -> word4;
            case 5 -> word5;
            case 6 -> word6;
            default -> throw new IllegalArgumentException("Position not valid.");
        };
    }
}
