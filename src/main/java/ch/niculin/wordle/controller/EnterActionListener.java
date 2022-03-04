package ch.niculin.wordle.controller;

import ch.niculin.wordle.gui.WordleView;
import ch.niculin.wordle.logic.WordleModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterActionListener implements ActionListener {

    private final WordleView view;
    private final WordleModel model;

    public EnterActionListener(WordleView view, WordleModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.wordIsValid(view.getWord())){
            view.colorLabels(model.rateCurrentWord(view.getWord()));
        }
        else {
            view.colorLabels(model.removeAllLettersOfCurrentRow());
        }
        if (model.gameCanContinue() && !model.IsWordTheSolution(view.getWord())){
            view.getBottomPanel().setVisible(false);
            view.getTopPanel().setVisible(false);
            view.getWinPanel().setVisible(true);
            view.getWinImageLabel().setVisible(false);
            view.getLoseImageField().setVisible(true);
        }
    }
}
