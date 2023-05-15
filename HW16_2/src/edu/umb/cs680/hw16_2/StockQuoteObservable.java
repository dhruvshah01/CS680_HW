package edu.umb.cs680.hw16_2;

import java.util.HashMap;

public class StockQuoteObservable extends Observable<StockEvent>{


    HashMap<String, Double> mapTickerQuote;
    public StockQuoteObservable() {
        this.mapTickerQuote = new HashMap<>();
    }

    public HashMap<String, Double> getMapTickerQuote() {
        return mapTickerQuote;
    }

    public void setMapTickerQuote(HashMap<String, Double> mapTickerQuote) {
        this.mapTickerQuote = mapTickerQuote;
    }

    public void changeQuote(String t, Double q){
        this.mapTickerQuote.put(t, q);
        notifyObservers(new StockEvent(t, q));
    }

    public void update(Observer<StockEvent> sender, Object event){
        System.out.println("Updating event");
    }

    public static void main(String[] args) {
        System.out.println("Implemented Stock Quote Observable Using LE");
    }
}
