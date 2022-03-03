package ch.niculin.wordle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class WordleView {
    private JPanel mainPanel;
    private final List<JLabel> fieldsToFillTry1;
    private final List<JLabel> fieldsToFillTry2;
    private final List<JLabel> fieldsToFillTry3;
    private final List<JLabel> fieldsToFillTry4;
    private final List<JLabel> fieldsToFillTry5;
    private final List<JLabel> fieldsToFillTry6;

    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton aButton;
    private JButton bButton;
    private JButton eButton;
    private JButton fButton;
    private JButton cButton;
    private JButton dButton;
    private JButton gButton;
    private JButton hButton;
    private JButton iButton;
    private JButton jButton;
    private JButton kButton;
    private JButton lButton;
    private JButton mButton;
    private JButton nButton;
    private JButton oButton;
    private JButton pButton;
    private JButton qButton;
    private JButton rButton;
    private JButton sButton;
    private JButton tButton;
    private JButton uButton;
    private JButton vButton;
    private JButton wButton;
    private JButton xButton;
    private JButton yButton;
    private JButton zButton;
    private JLabel Try1_1;
    private JLabel Try1_2;
    private JLabel Try1_3;
    private JLabel Try1_4;
    private JLabel Try1_5;
    private JLabel Try2_1;
    private JLabel Try2_2;
    private JLabel Try2_3;
    private JLabel Try2_4;
    private JLabel Try2_5;
    private JLabel Try3_1;
    private JLabel Try3_2;
    private JLabel Try3_3;
    private JLabel Try3_4;
    private JLabel Try3_5;
    private JLabel Try4_2;
    private JLabel Try4_3;
    private JLabel Try4_4;
    private JLabel Try4_5;
    private JLabel Try5_1;
    private JLabel Try5_2;
    private JLabel Try5_3;
    private JLabel Try5_4;
    private JLabel Try5_5;
    private JLabel Try6_1;
    private JLabel Try6_2;
    private JLabel Try6_3;
    private JLabel Try6_4;
    private JLabel Try6_5;
    private JLabel Try4_1;
    private JButton clearButton;
    private JButton enterButton;
    private JLabel toShortLabel;
    private JLabel endLabel;
    private JPanel winPanel;
    private JLabel imageLabel;

    public JButton getaButton() {
        return aButton;
    }

    public JButton getbButton() {
        return bButton;
    }

    public JButton geteButton() {
        return eButton;
    }

    public JButton getfButton() {
        return fButton;
    }

    public JButton getcButton() {
        return cButton;
    }

    public JButton getdButton() {
        return dButton;
    }

    public JButton getgButton() {
        return gButton;
    }

    public JButton gethButton() {
        return hButton;
    }

    public JButton getiButton() {
        return iButton;
    }

    public JButton getjButton() {
        return jButton;
    }

    public JButton getkButton() {
        return kButton;
    }

    public JButton getlButton() {
        return lButton;
    }

    public JButton getmButton() {
        return mButton;
    }

    public JButton getnButton() {
        return nButton;
    }

    public JButton getoButton() {
        return oButton;
    }

    public JButton getpButton() {
        return pButton;
    }

    public JButton getqButton() {
        return qButton;
    }

    public JButton getrButton() {
        return rButton;
    }

    public JButton getsButton() {
        return sButton;
    }

    public JButton gettButton() {
        return tButton;
    }

    public JButton getuButton() {
        return uButton;
    }

    public JButton getvButton() {
        return vButton;
    }

    public JButton getwButton() {
        return wButton;
    }

    public JButton getxButton() {
        return xButton;
    }

    public JButton getyButton() {
        return yButton;
    }

    public JButton getzButton() {
        return zButton;
    }

    public void setButtonA(ActionListener addActionListener) {
        this.aButton.addActionListener(addActionListener);
    }

    public void setbButton(ActionListener addActionListener) {
        this.bButton.addActionListener(addActionListener);
    }

    public void setcButton(ActionListener addActionListener) {
        this.cButton.addActionListener(addActionListener);
    }

    public void setdButton(ActionListener addActionListener) {
        this.dButton.addActionListener(addActionListener);
    }

    public void seteButton(ActionListener addActionListener) {
        this.eButton.addActionListener(addActionListener);
    }

    public void setfButton(ActionListener addActionListener) {
        this.fButton.addActionListener(addActionListener);
    }

    public void setgButton(ActionListener addActionListener) {
        this.gButton.addActionListener(addActionListener);
    }

    public void sethButton(ActionListener addActionListener) {
        this.hButton.addActionListener(addActionListener);
    }

    public void setiButton(ActionListener addActionListener) {
        this.iButton.addActionListener(addActionListener);
    }

    public void setjButton(ActionListener addActionListener) {
        this.jButton.addActionListener(addActionListener);
    }

    public void setkButton(ActionListener addActionListener) {
        this.kButton.addActionListener(addActionListener);
    }

    public void setlButton(ActionListener addActionListener) {
        this.lButton.addActionListener(addActionListener);
    }

    public void setmButton(ActionListener addActionListener) {
        this.mButton.addActionListener(addActionListener);
    }

    public void setnButton(ActionListener addActionListener) {
        this.nButton.addActionListener(addActionListener);
    }

    public void setoButton(ActionListener addActionListener) {
        this.oButton.addActionListener(addActionListener);
    }

    public void setpButton(ActionListener addActionListener) {
        this.pButton.addActionListener(addActionListener);
    }

    public void setqButton(ActionListener addActionListener) {
        this.qButton.addActionListener(addActionListener);
    }

    public void setrButton(ActionListener addActionListener) {
        this.rButton.addActionListener(addActionListener);
    }

    public void setsButton(ActionListener addActionListener) {
        this.sButton.addActionListener(addActionListener);
    }

    public void settButton(ActionListener addActionListener) {
        this.tButton.addActionListener(addActionListener);
    }

    public void setuButton(ActionListener addActionListener) {
        this.uButton.addActionListener(addActionListener);
    }

    public void setvButton(ActionListener addActionListener) {
        this.vButton.addActionListener(addActionListener);
    }

    public void setwButton(ActionListener addActionListener) {
        this.wButton.addActionListener(addActionListener);
    }

    public void setxButton(ActionListener addActionListener) {
        this.xButton.addActionListener(addActionListener);
    }

    public void setyButton(ActionListener addActionListener) {
        this.yButton.addActionListener(addActionListener);
    }

    public void setzButton(ActionListener addActionListener) {
        this.zButton.addActionListener(addActionListener);
    }

    public void setClearButton(ActionListener addActionListener) {
        this.clearButton.addActionListener(addActionListener);
    }

    public void setEnterButton(ActionListener addActionListener) {
        this.enterButton.addActionListener(addActionListener);
    }

    public void setLetter(Letter letter) {
        var index = Position.getInstance().getPosition();
        getCurrentRow().get(index).setText(letter.getLetter());
    }

    public void deleteLetter(Letter letter) {
        var index = Position.getInstance().getPosition();
        getCurrentRow().get(index).setText(letter.getLetter());
    }

    private List<JLabel> getCurrentRow() {
        switch (Position.getInstance().getRound()) {
            case 1 -> {
                return fieldsToFillTry1;
            }
            case 2 -> {
                return fieldsToFillTry2;
            }
            case 3 -> {
                return fieldsToFillTry3;
            }
            case 4 -> {
                return fieldsToFillTry4;
            }
            case 5 -> {
                return fieldsToFillTry5;
            }
            case 6 -> {
                return fieldsToFillTry6;
            }
            default -> {
                return new ArrayList<>();
            }
        }
    }

    public JLabel getToShortLabel() {
        return toShortLabel;
    }

    public JLabel getEndLabel() {
        return endLabel;
    }

    {
        fieldsToFillTry1 = new ArrayList<>();
        fieldsToFillTry2 = new ArrayList<>();
        fieldsToFillTry3 = new ArrayList<>();
        fieldsToFillTry4 = new ArrayList<>();
        fieldsToFillTry5 = new ArrayList<>();
        fieldsToFillTry6 = new ArrayList<>();

        fieldsToFillTry1.add(Try1_1);
        fieldsToFillTry1.add(Try1_2);
        fieldsToFillTry1.add(Try1_3);
        fieldsToFillTry1.add(Try1_4);
        fieldsToFillTry1.add(Try1_5);

        fieldsToFillTry2.add(Try2_1);
        fieldsToFillTry2.add(Try2_2);
        fieldsToFillTry2.add(Try2_3);
        fieldsToFillTry2.add(Try2_4);
        fieldsToFillTry2.add(Try2_5);

        fieldsToFillTry3.add(Try3_1);
        fieldsToFillTry3.add(Try3_2);
        fieldsToFillTry3.add(Try3_3);
        fieldsToFillTry3.add(Try3_4);
        fieldsToFillTry3.add(Try3_5);

        fieldsToFillTry4.add(Try4_1);
        fieldsToFillTry4.add(Try4_2);
        fieldsToFillTry4.add(Try4_3);
        fieldsToFillTry4.add(Try4_4);
        fieldsToFillTry4.add(Try4_5);

        fieldsToFillTry5.add(Try5_1);
        fieldsToFillTry5.add(Try5_2);
        fieldsToFillTry5.add(Try5_3);
        fieldsToFillTry5.add(Try5_4);
        fieldsToFillTry5.add(Try5_5);

        fieldsToFillTry6.add(Try6_1);
        fieldsToFillTry6.add(Try6_2);
        fieldsToFillTry6.add(Try6_3);
        fieldsToFillTry6.add(Try6_4);
        fieldsToFillTry6.add(Try6_5);
    }

    public Word getWord() {
        return new Word(
                new Letter(getCurrentRow().get(0).getText(), State.NOTHING),
                new Letter(getCurrentRow().get(1).getText(), State.NOTHING),
                new Letter(getCurrentRow().get(2).getText(), State.NOTHING),
                new Letter(getCurrentRow().get(3).getText(), State.NOTHING),
                new Letter(getCurrentRow().get(4).getText(), State.NOTHING));
    }

    public WordleView() {

        JFrame frame = new JFrame("ch.niculin.wordle.gui.WorddleGui");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        endLabel.setVisible(false);
        toShortLabel.setVisible(false);
        winPanel.setVisible(false);
    }

    public void colorLabels(Word word) {
        List<State> statesOfLetters = word.getWordStates();
        List<String> volumeOfLetters = word.getWordVolume();

        if (!statesOfLetters.contains(State.WRONG) && !statesOfLetters.contains(State.SEMI_CORRECT) && !statesOfLetters.contains(State.NOTHING)){
            winPanel.setVisible(true);
            topPanel.setVisible(false);
            bottomPanel.setVisible(false);
        } else {
            if (volumeOfLetters.contains("__")) {
                removeAll();
                getToShortLabel().setVisible(true);
                Position.getInstance().minusOneRound();
            } else{
                getToShortLabel().setVisible(false);
                for (int i = 0; i <= 4; i++) {
                    if (statesOfLetters.get(i) == State.WRONG) {
                        getCurrentRow().get(i).setBackground(Color.red);
                        getCurrentRow().get(i).setOpaque(true);
                        Color color = getButtonToColour(getCurrentRow().get(i).getText()).getBackground();
                        if (color.equals(new Color(252, 250, 255))) {
                            getButtonToColour(getCurrentRow().get(i).getText()).setBackground(Color.red);
                            getButtonToColour(getCurrentRow().get(i).getText()).setOpaque(true);
                        }
                    } else if (statesOfLetters.get(i) == State.SEMI_CORRECT) {
                        getCurrentRow().get(i).setBackground(Color.ORANGE);
                        getCurrentRow().get(i).setOpaque(true);

                        getButtonToColour(getCurrentRow().get(i).getText()).setBackground(Color.orange);
                        getButtonToColour(getCurrentRow().get(i).getText()).setOpaque(true);

                    } else {
                        getCurrentRow().get(i).setBackground(Color.green);
                        getCurrentRow().get(i).setOpaque(true);

                        getButtonToColour(getCurrentRow().get(i).getText()).setBackground(Color.green);
                        getButtonToColour(getCurrentRow().get(i).getText()).setOpaque(true);

                    }
                    System.out.println(getCurrentRow().get(i).getBackground());
                    System.out.println(getButtonToColour(getCurrentRow().get(i).getText()).getBackground());
                }
            }
        }
    }

    private void removeAll() {
        for (JLabel jLabel : getCurrentRow()) {
            jLabel.setText("__");
        }
    }

    private JButton getButtonToColour(String letter) {
        return switch (letter) {
            case "A" -> aButton;
            case "B" -> bButton;
            case "C" -> cButton;
            case "D" -> dButton;
            case "E" -> eButton;
            case "F" -> fButton;
            case "G" -> gButton;
            case "H" -> hButton;
            case "I" -> iButton;
            case "J" -> jButton;
            case "K" -> kButton;
            case "L" -> lButton;
            case "M" -> mButton;
            case "N" -> nButton;
            case "O" -> oButton;
            case "P" -> pButton;
            case "Q" -> qButton;
            case "R" -> rButton;
            case "S" -> sButton;
            case "T" -> tButton;
            case "U" -> uButton;
            case "V" -> vButton;
            case "W" -> wButton;
            case "X" -> xButton;
            case "Y" -> yButton;
            case "Z" -> zButton;
            default -> new JButton();
        };
    }

    private void createUIComponents() {
        imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/winImage.jpg").getImage().getScaledInstance(450,600, Image.SCALE_SMOOTH));
        imageLabel.setIcon(imageIcon);
    }
}
