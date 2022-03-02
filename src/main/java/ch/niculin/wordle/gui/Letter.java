package ch.niculin.wordle.gui;

public class Letter {
    private  String volume;
    private  State state;

    public Letter (String volume, State state){
        this.state = state;
        this.volume = volume;
    }


    public State getState() {
        return state;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setState(State state) {
        this.state = state;
    }
}
