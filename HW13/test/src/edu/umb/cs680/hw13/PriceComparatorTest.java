package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PriceComparatorTest {
    private static ArrayList<Car> usedCars = new ArrayList<>();
    @BeforeAll
    public static void setup(){
        usedCars.add(new Car("Honda", "RAV4", 2018, 25, 15000f));
        usedCars.add(new Car("Toyota", "Corola", 2020, 29, 14500f));
        usedCars.add(new Car("Hyundai", "Elantara", 2019, 20, 20000f));
        usedCars.add(new Car("Audi", "Q3", 2015, 21, 12000f));
    }
    @Test
    public void PriceComparatorLETest(){
        ArrayList<Float> expected = new ArrayList<>();
        expected.add(12000f);
        expected.add(14500f);
        expected.add(15000f);
        expected.add(20000f);

        Collections.sort(usedCars, Comparator.comparing((Car car) -> car.getPrice()));

        ArrayList<Float> actual = new ArrayList<>();

        for (Car car : usedCars){
            actual.add(car.getPrice());
        }

        assertArrayEquals(actual.toArray(), expected.toArray());

    }

    @Test
    public void PriceComparatorLETestDescendingOrder(){
        ArrayList<Float> expected = new ArrayList<>();
        expected.add(20000f);
        expected.add(15000f);
        expected.add(14500f);
        expected.add(12000f);

        Collections.sort(usedCars, Comparator.comparing((Car car) -> car.getPrice(), Comparator.reverseOrder()));

        ArrayList<Float> actual = new ArrayList<>();

        for (Car car : usedCars){
            actual.add(car.getPrice());
        }
        assertArrayEquals(actual.toArray(), expected.toArray());

    }

}
