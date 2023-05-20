package edu.umb.cs680.hw15;

public class AggressiveBatsmanStrategy implements  Strategy{

    int StrikeRate = 0;
    boolean powerHitting = false;

    public int getStrikeRate() {
        return StrikeRate;
    }

    public void setStrikeRate(int strikeRate) {
        StrikeRate = strikeRate;
    }

    public boolean isPowerHitting() {
        return powerHitting;
    }

    public void setPowerHitting(boolean powerHitting) {
        this.powerHitting = powerHitting;
    }

    @Override
    public void execute() {
        setStrikeRate(150);
        setPowerHitting(true);
        System.out.println("Aggressive Batting Approach");
        System.out.println("Expected StrikeRate: " + this.getStrikeRate());
        System.out.println("Power Hitting: " + this.isPowerHitting());
    }
}
