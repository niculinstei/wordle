package ch.niculin.wordle.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordCheckerImplTest {

    WordCheckerImpl wordChecker;
    WordleModel model = new WordleModel();
    @BeforeEach
    void setUp(){
        wordChecker = new WordCheckerImpl(model.getWordList());
    }

    @Test
    void success(){
        Word word = new Word("PIZZA");
        wordChecker.solution = "PIZZA";
        boolean condition = wordChecker.checkUserWordInput(word).getWordVolumeAsString().equals(wordChecker.solution);
        assertTrue(condition);
    }

    @Test
    void invalidSuccess(){
        Word word = new Word("VOGEL");
        boolean condition = wordChecker.checkUserWordInput(word).getWordVolumeAsString().equals(wordChecker.solution);
        assertFalse(condition);
    }

    @Test
    void successMethode() {
        Word word = new Word("PIZZA");
        Word returnWord = wordChecker.checkUserWordInput(word);
        boolean condition = returnWord.getWordStates().contains(State.WRONG) || returnWord.getWordStates().contains(State.SEMI_CORRECT) || returnWord.getWordStates().contains(State.NOTHING);
        assertFalse(condition);
    }
}
