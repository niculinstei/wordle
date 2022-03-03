package ch.niculin.wordle.logic;

import ch.niculin.wordle.gui.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordCheckerImplTest {

    WordCheckerImpl wordChecker;
    @BeforeEach
    void setUp(){
        wordChecker = new WordCheckerImpl();
    }

    @Test
    void success(){
        Word word = new Word("PIZZA");
        boolean condition = wordChecker.checkUserWordInput(word).getWordVolumeAsString().equals(wordChecker.solution);
        assertTrue(condition);
    }

    @Test
    void invalidSuccess(){
        Word word = new Word("VOGEL");
        boolean condition = wordChecker.checkUserWordInput(word).getWordVolumeAsString().equals(wordChecker.solution);
        assertFalse(condition);
    }
}
