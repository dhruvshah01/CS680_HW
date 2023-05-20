package edu.umb.cs680.hw15;



public class AggressiveFieldingStrategy implements Strategy{
    int fieldersOutside30Yard = 0;

    public int getFieldersOutside30Yard() {
        return fieldersOutside30Yard;
    }

    public AggressiveFieldingStrategy() {
    }

    public void setFieldersOutside30Yard(int fieldersOutside30Yard) {
        this.fieldersOutside30Yard = fieldersOutside30Yard;
    }

    @Override
    public void execute() {
        setFieldersOutside30Yard(2);
        System.out.println("Aggressive Fielding Strategy");
        System.out.println("Fielders Outside 30 Yard: " + this.getFieldersOutside30Yard());
    }
}
