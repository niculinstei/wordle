package ch.niculin.wordle.controller;

import ch.niculin.wordle.gui.WordleView;
import ch.niculin.wordle.logic.WordleModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearActionListener implements ActionListener {
    private final WordleView view;
    private final WordleModel model;

    public ClearActionListener(WordleView view, WordleModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.deleteLetter(model.deleteCurrentLetter());
    }
}
