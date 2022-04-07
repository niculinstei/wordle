package ch.niculin.wordle.controller;

import ch.niculin.wordle.gui.WordleView;
import ch.niculin.wordle.logic.Word;
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
            Word ratedWord = model.rateCurrentWord(view.getWord());
            view.colorLabels(ratedWord);
            model.save();
        }
        else {
            view.colorLabels(model.removeAllLettersOfCurrentRow());
            model.save();
        }


        if (model.gameCanContinueForListener() && model.IsWordTheSolutionInverted(view.getWord())){
            System.out.println("lets gooo");
        } else if (model.IsWordTheSolutionInverted(view.getWord())){
            view.getBottomPanel().setVisible(false);
            view.getTopPanel().setVisible(false);
            view.getWinPanel().setVisible(true);
            view.getWinImageLabel().setVisible(false);
            view.getLoseImageField().setVisible(true);
        }
         else {
            view.getLoseImageField().setVisible(false);
            view.getWinPanel().setVisible(true);
            view.getTopPanel().setVisible(false);
            view.getBottomPanel().setVisible(false);
        }
    }
}
