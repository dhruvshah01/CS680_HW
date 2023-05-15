package edu.umb.cs680.hw16_1;

import java.util.HashMap;

public class StockQuoteObservable extends Observable<StockEvent>{
    HashMap<String, Double> mapTickerQuote;
    public StockQuoteObservable() {
        this.mapTickerQuote = new HashMap<>();
    }
    public void changeQuote(String t, Double q){
        this.mapTickerQuote.put(t, q);
        notifyObservers(new StockEvent(t, q));
    }

    public static void main(String[] args) {
        System.out.println("Implemented Stock Quote Observable");
    }
}
