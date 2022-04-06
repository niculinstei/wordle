package ch.niculin.wordle.logic;

import java.util.List;

public class Words {
    //TODO könnte man auf liste von wörter umbauen
    private final Word word1;
    private final Word word2;
    private final Word word3;
    private final Word word4;
    private final Word word5;
    private final Word word6;

    public Words(Word word1, Word word2, Word word3, Word word4, Word word5, Word word6) {
        this.word1 = word1;
        this.word2 = word2;
        this.word3 = word3;
        this.word4 = word4;
        this.word5 = word5;
        this.word6 = word6;
    }

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
