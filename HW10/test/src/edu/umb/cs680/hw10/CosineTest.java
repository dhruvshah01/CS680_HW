package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.DoublePredicate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosineTest {

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
    public void verifyCosineDistance(){
        List<Double> p1 = Arrays.asList(2.0, 3.0);
        List<Double> p2 = Arrays.asList(5.0, 7.0);
        double actual = Distance.get(p1, p2, new Cosine());
        double expected = 0.9994801143396996;
        assertEquals(actual, expected);
    }

    @Test
    public void verifyCosineMatrixTest(){
        Double [][] expected = {{1.0, 0.998211097487345, 0.999339517092495, 0.9997346012077565, 0.996254754422932},
                {0.998211097487345, 0.9999999999999998, 0.9997244376995309, 0.9993235404626273, 0.9893028897566322},
                {0.999339517092495, 0.9997244376995309, 1.0000000000000002, 0.9999114559990323, 0.992454629302117},
                {0.9997346012077565, 0.9993235404626273, 0.9999114559990323, 1.0000000000000002, 0.9939983750740026},
                {0.996254754422932, 0.9893028897566322, 0.992454629302117, 0.9939983750740026, 1.0}};
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

        List<Double> normalized_car1 = minMaxNormalization(car1);
        List<Double> normalized_car2 = minMaxNormalization(car2);
        List<Double> normalized_car3 = minMaxNormalization(car3);
        List<Double> normalized_car4 = minMaxNormalization(car4);
        List<Double> normalized_car5 = minMaxNormalization(car5);

        //System.out.printf(Arrays.toString(normalized_car.toArray()));
        List<List<Double>> actual = new ArrayList<>();
        actual.add(Arrays.asList(normalized_car1.get(0), normalized_car1.get(1), normalized_car1.get(2)));
        actual.add(Arrays.asList(normalized_car2.get(0), normalized_car2.get(1), normalized_car2.get(2)));
        actual.add(Arrays.asList(normalized_car3.get(0), normalized_car3.get(1), normalized_car3.get(2)));
        actual.add(Arrays.asList(normalized_car4.get(0), normalized_car4.get(1), normalized_car4.get(2)));
        actual.add(Arrays.asList(normalized_car5.get(0), normalized_car5.get(1), normalized_car5.get(2)));

        actual = Distance.matrix(actual, new Cosine());
        for(int i = 0; i < expected.length; i++){
            Double tmp[] = new Double[5];
            assertArrayEquals(expected[i], actual.get(i).toArray(tmp));
        }

    }

}
