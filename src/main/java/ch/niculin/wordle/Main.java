package ch.niculin.wordle;

import ch.niculin.wordle.controller.WordleController;
import ch.niculin.wordle.logic.WordleModel;
import ch.niculin.wordle.gui.WordleView;

public class Main {
    public static void main(String[] args) {
        WordleView theView =  new WordleView();
        WordleModel theWordle = new WordleModel();
        new WordleController(theView, theWordle);

    }
}
