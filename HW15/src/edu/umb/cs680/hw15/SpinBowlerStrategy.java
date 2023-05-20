package edu.umb.cs680.hw15;

public class SpinBowlerStrategy implements Strategy{
    int pace = 0;
    int lengthBallMark = 0;

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public int getLengthBallMark() {
        return lengthBallMark;
    }

    public void setLengthBallMark(int lengthBallMark) {
        this.lengthBallMark = lengthBallMark;
    }

    @Override
    public void execute() {
        setPace(90);
        setLengthBallMark(7);
        System.out.println("Spin Bowling Strategy");
        System.out.println("Expected Bowling Speed: " + this.getPace());
        System.out.println("Expected Length: " + this.getLengthBallMark());
    }
}
