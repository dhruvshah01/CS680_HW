package edu.umb.cs680.hw13;

import java.util.ArrayList;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;
    private int dominationCount = 0;

    public Car(String make, String model, int year, int mileage, float price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public int getDominationCount(){
        return dominationCount;
    }

    public void setDominationCount(ArrayList<Car> usedCars){
        for (int i = 0; i < usedCars.size(); i++){
            if ((this.mileage <= usedCars.get(i).mileage) && (this.price >= usedCars.get(i).price)
                    && (this.year <= usedCars.get(i).year)) {

                if ((this.mileage != usedCars.get(i).mileage)
                        || (this.price != usedCars.get(i).price)
                        || (this.year != usedCars.get(i).year)) {
                    this.dominationCount++;
                }
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("Implemented Car class with LE Expression");
    }

}
