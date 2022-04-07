package ch.niculin.wordle.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordCheckerImplTest {
    WordCheckerImpl wordChecker;
    WordleModel model = new WordleModel();
    Solution solution;
    @BeforeEach
    void setUp(){
        wordChecker = new WordCheckerImpl(model.getWordList());
        solution = wordChecker.getSolution();
    }

    @Test
    void success(){
        Word word = new Word(solution.getSolution().toUpperCase(Locale.ROOT));
        boolean condition = wordChecker.checkUserWordInput(word).getWordAsString().equals(solution.getSolution().toUpperCase(Locale.ROOT));
        assertTrue(condition);
    }

    @Test
    void invalidSuccess(){
        Word word = new Word("VOGEL");
        boolean condition = wordChecker.checkUserWordInput(word).getWordAsString().equals(solution.toString().toUpperCase(Locale.ROOT));
        assertFalse(condition);
    }
}
