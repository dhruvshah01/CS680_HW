package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class BattingStrategyTest {
    @Test
    public void verifyDefensiveBattingStrategy(){
        Cricket c = new Cricket();
        c.setStrategy(new DefensiveBatsmanStrategy());
        c.playGame();
        Strategy actual = c.getStrategy();
        assertInstanceOf(DefensiveBatsmanStrategy.class, actual);
    }

    @Test
    public void verifyAggressiveBattingStrategy(){
        Cricket c = new Cricket();
        c.setStrategy(new AggressiveBatsmanStrategy());
        c.playGame();
        Strategy actual = c.getStrategy();
        assertInstanceOf(AggressiveBatsmanStrategy.class, actual);
    }
}
