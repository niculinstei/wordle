package ch.niculin.wordle.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LetterActionListener implements ActionListener {
    private final WordleModel wordleModel;
    private final WordleView wordleView;
    private final String anyTextOfButton;


    public LetterActionListener(String anyTextOfButton, WordleView wordleView, WordleModel wordleModel) {
        this.wordleView = wordleView;
        this.wordleModel = wordleModel;
        this.anyTextOfButton = anyTextOfButton;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        wordleView.setLetter(wordleModel.setNextLetter(anyTextOfButton));

    }
}
