package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ParetoComparatorTest {
    private static ArrayList<Car> usedCars = new ArrayList<>();
    @BeforeAll
    public static void setup(){
        usedCars.add(new Car("Honda", "RAV4", 2018, 25, 15000f));
        usedCars.add(new Car("Toyota", "Corola", 2020, 29, 14500f));
        usedCars.add(new Car("Hyundai", "Elantara", 2019, 20, 20000f));
        usedCars.add(new Car("Audi", "Q3", 2015, 21, 12000f));
    }

    @Test
    public void ParetoComparatorLETest(){
        ArrayList<String> expected = new ArrayList<>();
        expected.add("RAV4");
        expected.add("Corola");
        expected.add("Elantara");
        expected.add("Q3");

        Collections.sort(usedCars, Comparator.comparing((Car car) -> car.getDominationCount()));

        ArrayList<String> actual = new ArrayList<>();

        for (Car car : usedCars){
            actual.add(car.getModel());
        }

        assertArrayEquals(actual.toArray(), expected.toArray());

    }

    @Test
    public void ParetoComparatorLETestDescendingOrder(){
        ArrayList<String> expected = new ArrayList<>();
        expected.add("RAV4");
        expected.add("Corola");
        expected.add("Elantara");
        expected.add("Q3");

        Collections.sort(usedCars, Comparator.comparing((Car car) -> car.getDominationCount(), Comparator.reverseOrder()));

        ArrayList<String> actual = new ArrayList<>();

        for (Car car : usedCars){
            actual.add(car.getModel());
        }
        assertArrayEquals(actual.toArray(), expected.toArray());

    }

}
