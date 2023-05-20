package edu.umb.cs680.hw15;

public class DefensiveFieldingStrategy implements Strategy{

    int fieldersOutside30Yard = 0;

    public int getFieldersOutside30Yard() {
        return fieldersOutside30Yard;
    }

    public DefensiveFieldingStrategy() {
    }

    public void setFieldersOutside30Yard(int fieldersOutside30Yard) {
        this.fieldersOutside30Yard = fieldersOutside30Yard;
    }

    @Override
    public void execute() {
        setFieldersOutside30Yard(5);
        System.out.println("Defensive Fielding Strategy");
        System.out.println("Fielders Outside 30 Yard: " + this.getFieldersOutside30Yard());
    }
}
