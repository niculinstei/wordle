package ch.niculin.wordle.controller;

import ch.niculin.wordle.gui.*;
import ch.niculin.wordle.logic.WordleModel;

public class WordleController {
    private final WordleView theView;
    private final WordleModel theModel;

    public WordleController(WordleView theView, WordleModel theModel) {
        this.theView = theView;
        this.theModel = theModel;

        setListener();
    }

    private void setListener() {
        theView.setButtonA(new LetterActionListener(theView.getaButton().getText(), theView, theModel));
        theView.setbButton(new LetterActionListener(theView.getbButton().getText(), theView, theModel));
        theView.setcButton(new LetterActionListener(theView.getcButton().getText(), theView, theModel));
        theView.setdButton(new LetterActionListener(theView.getdButton().getText(), theView, theModel));
        theView.seteButton(new LetterActionListener(theView.geteButton().getText(), theView, theModel));
        theView.setfButton(new LetterActionListener(theView.getfButton().getText(), theView, theModel));
        theView.setgButton(new LetterActionListener(theView.getgButton().getText(), theView, theModel));
        theView.sethButton(new LetterActionListener(theView.gethButton().getText(), theView, theModel));
        theView.setiButton(new LetterActionListener(theView.getiButton().getText(), theView, theModel));
        theView.setjButton(new LetterActionListener(theView.getjButton().getText(), theView, theModel));
        theView.setkButton(new LetterActionListener(theView.getkButton().getText(), theView, theModel));
        theView.setlButton(new LetterActionListener(theView.getlButton().getText(), theView, theModel));
        theView.setmButton(new LetterActionListener(theView.getmButton().getText(), theView, theModel));
        theView.setnButton(new LetterActionListener(theView.getnButton().getText(), theView, theModel));
        theView.setoButton(new LetterActionListener(theView.getoButton().getText(), theView, theModel));
        theView.setpButton(new LetterActionListener(theView.getpButton().getText(), theView, theModel));
        theView.setqButton(new LetterActionListener(theView.getqButton().getText(), theView, theModel));
        theView.setrButton(new LetterActionListener(theView.getrButton().getText(), theView, theModel));
        theView.setsButton(new LetterActionListener(theView.getsButton().getText(), theView, theModel));
        theView.settButton(new LetterActionListener(theView.gettButton().getText(), theView, theModel));
        theView.setuButton(new LetterActionListener(theView.getuButton().getText(), theView, theModel));
        theView.setvButton(new LetterActionListener(theView.getvButton().getText(), theView, theModel));
        theView.setwButton(new LetterActionListener(theView.getwButton().getText(), theView, theModel));
        theView.setxButton(new LetterActionListener(theView.getxButton().getText(), theView, theModel));
        theView.setyButton(new LetterActionListener(theView.getyButton().getText(), theView, theModel));
        theView.setzButton(new LetterActionListener(theView.getzButton().getText(), theView, theModel));
        theView.setClearButton(new ClearActionListener(theView, theModel));
        theView.setEnterButton(new EnterActionListener(theView, theModel));
    }
}
