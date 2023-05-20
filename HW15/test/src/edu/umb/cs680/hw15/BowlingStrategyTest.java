package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class BowlingStrategyTest {
    @Test
    public void verifyPaceBowlingStrategy(){
        Cricket c = new Cricket();
        c.setStrategy(new PaceBowlerStrategy());
        c.playGame();
        Strategy actual = c.getStrategy();
        assertInstanceOf(PaceBowlerStrategy.class, actual);
    }

    @Test
    public void verifySpinBowlingStrategy(){
        Cricket c = new Cricket();
        c.setStrategy(new SpinBowlerStrategy());
        c.playGame();
        Strategy actual = c.getStrategy();
        assertInstanceOf(SpinBowlerStrategy.class, actual);
    }
}
