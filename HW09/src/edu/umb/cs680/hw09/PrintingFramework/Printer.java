package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.Login.LoggedIn;

public class Printer {

    private static final Printer instance = new Printer();

    private Printer(){
        //Empty Constructor
    }

    public static Printer getInstance(){
        return instance;
    }
    public void print(){
        System.out.println("Singleton Printer Class");
    }

    public static void main(String[] args) {

    }
}
