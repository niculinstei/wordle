package ch.niculin.wordle;

import ch.niculin.wordle.gui.WordleController;
import ch.niculin.wordle.gui.WordleModel;
import ch.niculin.wordle.gui.WordleView;

public class Main {
    public static void main(String[] args) {
        WordleView theView =  new WordleView();
        WordleModel theWordle = new WordleModel();
        WordleController wordleController = new WordleController(theView, theWordle);
    }
}
