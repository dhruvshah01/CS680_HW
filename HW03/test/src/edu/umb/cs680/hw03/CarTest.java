package edu.umb.cs680.hw03;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class CarTest {

    private String[] carToStringArray(Car carInstance){
        String[] carSpecifications = {carInstance.getMake(), carInstance.getModel(), Integer.toString(carInstance.getYear())};
        return carSpecifications;
    }

    @Test
    void verifyCarEqualityWithModelYear(){
        String[] expected = {"Toyota", "RAV4", "2018"};
        Car car1 = new Car("Toyota", "RAV4", 2018);
        Car car2 = new Car("Buggati", "Veyron", 2020);
        assertArrayEquals(expected, carToStringArray(car1));
        assertNotEquals(expected, carToStringArray(car2));
    }

}
