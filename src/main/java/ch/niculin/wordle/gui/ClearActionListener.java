package ch.niculin.wordle.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearActionListener implements ActionListener {
    private WordleView view;
    private WordleModel model;

    public ClearActionListener(WordleView view, WordleModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.deleteLetter(model.deleteCurrentLetter());

    }
}
