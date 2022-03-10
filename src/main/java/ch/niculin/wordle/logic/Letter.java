package ch.niculin.wordle.logic;

public class Letter {
    private  String letter;
    private State state;

    public Letter (String letter, State state){
        this.state = state;
        this.letter = letter;
    }


    public State getState() {
        return state;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String volume) {
        this.letter = volume;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isValid() {
        return !letter.equals("_");
    }
}
