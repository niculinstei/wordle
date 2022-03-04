package ch.niculin.wordle.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordleModelTest {
    WordleModel wordleModel;

    @BeforeEach
    void setUp() {
        wordleModel = new WordleModel();
    }

    @Test
    void testValidLetterToSet() {
        String letter = "A";
        Letter letterObject = wordleModel.setNextLetter(letter);
        boolean condition = letterObject.getLetter().equals(letter);
        assertTrue(condition);
    }

    @Test
    void deleteCurrentLetterTest() {
            Letter deletedLetter = wordleModel.deleteCurrentLetter();
            boolean condition = deletedLetter.getLetter().equals("__");
            assertTrue(condition);
    }

    @Test
    void testRemoveAll() {
        Word removedRow = wordleModel.removeAllLettersOfCurrentRow();
        boolean condition = !removedRow.getWordLetter().stream().allMatch(Letter :: isValid);
        assertTrue(condition);
    }

    @Test
    void validWord() {
        Word word = new Word("VOGEL");
        boolean condition = wordleModel.wordIsValid(word);
        assertTrue(condition);
    }

    @Test
    void inValidWord() {
        Word word = new Word("ASDFG");
        boolean condition = wordleModel.wordIsValid(word);
        assertFalse(condition);
    }


/*    @Test
    void canGameContinue() {
        boolean condition = wordleModel.gameCanContinue();
        assertTrue(condition);
    }*/
}
