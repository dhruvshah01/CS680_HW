package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    public void verifyPrimeNumebersFrom1to15(){
        try{
            PrimeGenerator primeGenerator = new PrimeGenerator(1, 15);
            primeGenerator.generatePrimes();
            Long[] actual = (Long[]) primeGenerator.getPrimes().toArray();
            Long[] expected = {2L, 3L, 5L, 7L, 11L, 13L};
            assertArrayEquals(expected, actual);
        }
        catch (RuntimeException ex){
            assertNotEquals("Wrong input values: from=" + 1L + " to=" + 15L, ex.getMessage());
        }
    }

    @Test
    void verifyPrimeNumebersFromNegative10to0(){

        try{
            PrimeGenerator primeGenerator = new PrimeGenerator(-10, 0);
            primeGenerator.generatePrimes();
            Long[] actual = (Long[]) primeGenerator.getPrimes().toArray();
            Long[] expected = {};
            assertArrayEquals(expected, actual);
        }
        catch (RuntimeException ex){
            assertEquals("Wrong input values: from=" + -10L + " to=" + 0L, ex.getMessage());
        }
    }
    @Test
    void generatePrimeNumbersFrom1to100(){
        try{
            PrimeGenerator primeGenerator = new PrimeGenerator(1, 100);
            primeGenerator.generatePrimes();
            Long[] actual = (Long[]) primeGenerator.getPrimes().toArray();
            Long[] expected = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
            assertArrayEquals(expected, actual);
        }
        catch (RuntimeException ex){
            assertNotEquals("Wrong input values: from=" + 1L + " to:" + 100L, ex.getMessage());
        }
    }

    @Test
    void generatePrimeNumbersFrom10to0(){
        try{
            PrimeGenerator primeGenerator = new PrimeGenerator(10, 0);
            primeGenerator.generatePrimes();
            Long[] actual = (Long[]) primeGenerator.getPrimes().toArray();
            Long[] expected = {};
            assertArrayEquals(expected, actual);
        }
        catch (RuntimeException ex){
            assertEquals("Wrong input values: from=" + 10L + " to=" + 0L, ex.getMessage());
        }
    }
}