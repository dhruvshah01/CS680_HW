package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldingStrategyTest {
    @Test
    public void verifyDefensiveFieldingStrategy(){
        Cricket c = new Cricket();
        c.setStrategy(new DefensiveFieldingStrategy());
        c.playGame();
        Strategy actual = c.getStrategy();
        assertInstanceOf(DefensiveFieldingStrategy.class, actual);
    }

    @Test
    public void verifyAggressiveFieldingStrategy(){
        Cricket c = new Cricket();
        c.setStrategy(new AggressiveFieldingStrategy());
        c.playGame();
        Strategy actual = c.getStrategy();
        assertInstanceOf(AggressiveFieldingStrategy.class, actual);
    }

}
