package edu.umb.cs680.hw10;

import java.util.List;

import static java.lang.Math.abs;

public class Manhattan implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double manhattan_distance = 0;
        for(int i=0; i < p1.size(); i++) {
            manhattan_distance += (p1.get(i) - p2.get(i));
        }
        return abs(manhattan_distance);
    }
}
