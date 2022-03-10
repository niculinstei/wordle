package ch.niculin.wordle;

import ch.niculin.wordle.controller.WordleController;
import ch.niculin.wordle.logic.WordleModel;
import ch.niculin.wordle.gui.WordleView;

public class Main {
    public static void main(String[] args) {
        WordleModel theWordle = new WordleModel();
        WordleView theView =  new WordleView();
        new WordleController(theView, theWordle);

    }
}
