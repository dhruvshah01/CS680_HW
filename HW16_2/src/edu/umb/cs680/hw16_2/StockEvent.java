package edu.umb.cs680.hw16_2;

public class StockEvent {
    private String ticker;
    private double quote;

    public StockEvent(String ticker, double quote) {
        this.ticker = ticker;
        this.quote = quote;
    }

    public String getTicker() {
        return ticker;
    }

    public double getQuote() {
        return quote;
    }
}
