package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonPrimeGeneratorTest {
    @Test
    void verifySingletonPrimeGeneratorInstance(){
        assertNotNull(SingletonPrimeGenerator.getInstance());
    }

    @Test
    void verifySingletonPrimeGeneratorInstancesAreSame(){
        SingletonPrimeGenerator instance1 = SingletonPrimeGenerator.getInstance();
        SingletonPrimeGenerator instance2 = SingletonPrimeGenerator.getInstance();
        assertSame(instance2, instance1);
    }

    @Test
    void verifyGetPrimesFrom1to20(){
        SingletonPrimeGenerator singletonPrimeGenerator = SingletonPrimeGenerator.getInstance();
        Long[] actual = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
        singletonPrimeGenerator.generatePrimes(1, 20);
        assertIterableEquals(Arrays.asList(actual),singletonPrimeGenerator.getPrimes());
    }

    @Test
    void verifyGetPrimesThrowsErrorForNegativeInputs(){
        SingletonPrimeGenerator singletonPrimeGenerator = SingletonPrimeGenerator.getInstance();
        try{
            Long[] actual = {};
            singletonPrimeGenerator.generatePrimes(-10, 10);
            assertIterableEquals(Arrays.asList(actual),singletonPrimeGenerator.getPrimes());
        }catch(RuntimeException ex){
            assertEquals("Wrong input values: from=" + -10L + " to=" + 10L, ex.getMessage());
        }
    }

}
