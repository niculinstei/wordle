package ch.niculin.wordle;

import ch.niculin.wordle.controller.WordleController;
import ch.niculin.wordle.logic.WordleModel;
import ch.niculin.wordle.gui.WordleView;

public class Main {
    public static void main(String[] args) {
        WordleModel model = new WordleModel();

        WordleView view = new WordleView(model.isWinScreen());
        new WordleController(view, model);
    }
}
