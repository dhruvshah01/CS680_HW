package edu.umb.cs680.hw09.PrintingFramework;

public class PrintJob implements Command{
    public PrintJob(){

    }
    @Override
    public void execute() {
        Printer printer = Printer.getInstance();
        printer.print();
    }

    public void doSomePrint(){
        System.out.println("Part of PrintJob Class.");
    }

    public static void main(String[] args) {

    }
}
