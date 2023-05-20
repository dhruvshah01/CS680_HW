package edu.umb.cs680.hw15;

public class Cricket {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void playGame(){
        strategy.execute();
    }

    public Strategy getStrategy(){
        return strategy;
    }

    public static void main(String[] args) {
        System.out.println("Implemented Cricket Strategies using Strategy Design Pattern");
    }


}
