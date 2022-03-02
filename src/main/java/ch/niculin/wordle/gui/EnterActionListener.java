package ch.niculin.wordle.gui;

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
            view.colorLabels(model.validateCurrentWord(view.getWord()));
        }
        else {
            view.getToShortLabel().setVisible(true);
            view.colorLabels(model.removeAll());
            Position.getInstance().minusOneRound();
        }
        if (Position.getInstance().plusOneRound()){
            Position.getInstance().resetPosition();
        } else {
            view.getEndLabel().setVisible(true);
        }
    }
}
