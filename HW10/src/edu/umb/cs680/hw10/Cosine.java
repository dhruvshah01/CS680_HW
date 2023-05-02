package edu.umb.cs680.hw10;

import java.util.List;

public class Cosine implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double dotProduct = 0;
        double squaredP1 = 0;
        double squaredP2 = 0;
        double cosineDistance = 0;
        for(int i=0; i < p1.size(); i++){
            dotProduct += p1.get(i)*p2.get(i);
            squaredP1 += Math.pow(p1.get(i), 2);
            squaredP2 += Math.pow(p2.get(i), 2);
        }

        squaredP1 = Math.sqrt(squaredP1);
        squaredP2 = Math.sqrt(squaredP2);

        if (squaredP1 != 0.0 | squaredP2 != 0.0){
            return cosineDistance = dotProduct / (squaredP1*squaredP2);
        }
        else {
            return 0;
        }
    }
}
