package ch.niculin.wordle.gui;

public class Position {
    private static Position INSTANCE;
    private static int position;
    private static int nextPosition;
    private static int round;

    private Position() {
        position = 0;
        nextPosition = 0;
        round = 1;
        System.out.println("Position : " + position);
    }

    public static Position getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Position();
        }
        return INSTANCE;
    }

    public void moveForward() {
        if (position < 4 && nextPosition > 0){
            position++;
        }
        if (nextPosition < 4){
            nextPosition++;
        }
    }

    public void moveBackward() {
        if (nextPosition < 3 && position > 0){
            position--;
        }
        if (nextPosition > 0){
            nextPosition--;
        }
    }

    public boolean plusOneRound() {
        if (round != 6) {
            round++;
            return true;
        } else {
            return false;
        }
    }

    public void minusOneRound() {
        if (round > 0) {
            round--;
        }
    }

    public int getRound() {
        return round;
    }

    public int getPosition() {
        return position;
    }

    public void resetPosition() {
        position = 0;
        nextPosition = 0;
    }

    public int getNextPosition() {
        return nextPosition;
    }
}
