package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

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
    public void PriceTest(){
        ArrayList<Float> expected = new ArrayList<>();
        expected.add(12000f);
        expected.add(14500f);
        expected.add(15000f);
        expected.add(20000f);

        Collections.sort(usedCars, new PriceComparator());

        ArrayList<Float> actual = new ArrayList<>();

        for (Car car : usedCars){
            actual.add(car.getPrice());
        }
        //System.out.printf(Arrays.toString(actual.toArray()));
        //System.out.println();
        //System.out.println(Arrays.toString(expected.toArray()));
        assertArrayEquals(actual.toArray(), expected.toArray());
    }
}
