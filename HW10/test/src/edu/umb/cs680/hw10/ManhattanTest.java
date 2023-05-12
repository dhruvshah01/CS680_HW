package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class ManhattanTest {

    public double findMin(List<Double> arr){
        double min = arr.get(0);
        for (int i = 0; i < arr.toArray().length; i++){
            if (arr.get(i) < min){
                min = arr.get(i);
            }
        }
        return min;
    }

    public double findMax(List<Double> arr){
        double max = arr.get(0);
        for (int i = 0; i < arr.toArray().length; i++){
            if (arr.get(i) > max){
                max = arr.get(i);
            }
        }
        return max;
    }

    public List<Double> minMaxNormalization(List<Double> arr){
        List<Double> car = new ArrayList<>();
        for (int i = 0; i < arr.toArray().length; i++){
            double tmp = ((arr.get(i) - findMin(arr))/(findMax(arr) - findMin(arr)));
            car.add(tmp);
        }
        return car;
    }

    @Test
    public void verifyManhattanTest(){
        List<Double> p1 = Arrays.asList(2.0, 3.0);
        List<Double> p2 = Arrays.asList(5.0, 7.0);
        double actual = Distance.get(p1, p2, new Manhattan());
        double expected = 7.0;
        assertEquals(actual, expected);
    }

    @Test
    public void verifyManhattanTestMatrix(){

        Double[][] expected = { {0.0, 0.33333333333333326, 1.2380952380952381, 1.0, 2.1523809523809523},
                                {0.33333333333333326, 0.0, 0.9047619047619047, 0.6666666666666667, 1.8190476190476192},
                                {1.2380952380952381, 0.9047619047619047, 0.0, 0.23809523809523803, 0.9142857142857144},
                                {1.0, 0.6666666666666667, 0.23809523809523803, 0.0, 1.1523809523809523},
                                {2.1523809523809523, 1.8190476190476192, 0.9142857142857144, 1.1523809523809523, 0.0}
                                };

        List<Double> car1 = new ArrayList<>();
        car1.add(5000.0);
        car1.add(2020.0);
        car1.add(10000.0);

        List<Double> car2 = new ArrayList<>();
        car2.add(6000.0);
        car2.add(2019.0);
        car2.add(15000.0);

        List<Double> car3 = new ArrayList<>();
        car3.add(8000.0);
        car3.add(2021.0);
        car3.add(20000.0);

        List<Double> car4 = new ArrayList<>();
        car4.add(10000.0);
        car4.add(2015.0);
        car4.add(25000.0);

        List<Double> car5 = new ArrayList<>();
        car5.add(12000.0);
        car5.add(2022.0);
        car5.add(23000.0);

        List<Double> priceNormalization = new ArrayList<>();
        priceNormalization.add(car1.get(2));
        priceNormalization.add(car2.get(2));
        priceNormalization.add(car3.get(2));
        priceNormalization.add(car4.get(2));
        priceNormalization.add(car5.get(2));

        List<Double> mileageNormalization = new ArrayList<>();
        mileageNormalization.add(car1.get(0));
        mileageNormalization.add(car2.get(0));
        mileageNormalization.add(car3.get(0));
        mileageNormalization.add(car4.get(0));
        mileageNormalization.add(car5.get(0));

        List<Double> yearNormalization = new ArrayList<>();
        yearNormalization.add(car1.get(1));
        yearNormalization.add(car2.get(1));
        yearNormalization.add(car3.get(1));
        yearNormalization.add(car4.get(1));
        yearNormalization.add(car5.get(1));

        List<Double> normalized_year = minMaxNormalization(yearNormalization);
        List<Double> normalized_mileage = minMaxNormalization(mileageNormalization);
        List<Double> normalized_price = minMaxNormalization(priceNormalization);


        //System.out.printf(Arrays.toString(normalized_car.toArray()));
        List<List<Double>> actual = new ArrayList<>();
        actual.add(Arrays.asList(normalized_mileage.get(0), normalized_year.get(0), normalized_price.get(0)));
        actual.add(Arrays.asList(normalized_mileage.get(1), normalized_year.get(1), normalized_price.get(1)));
        actual.add(Arrays.asList(normalized_mileage.get(2), normalized_year.get(2), normalized_price.get(2)));
        actual.add(Arrays.asList(normalized_mileage.get(3), normalized_year.get(3), normalized_price.get(3)));
        actual.add(Arrays.asList(normalized_mileage.get(4), normalized_year.get(4), normalized_price.get(4)));


        actual = Distance.matrix(actual, new Manhattan());

        for(int i = 0; i < expected.length; i++){
            Double tmp[] = new Double[5];
            assertArrayEquals(expected[i], actual.get(i).toArray(tmp));
        }
        //assertEquals(Arrays.deepEquals(expected.toArray()), Distance.matrix(actual, new Manhattan()).toArray());

    }
}
