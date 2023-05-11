package edu.umb.cs680.hw16_1;

public class TableObserver implements Observer{
    private StockEvent stockEvent;

    public StockEvent getStockEvent() {
        return stockEvent;
    }

    @Override
    public void update(Observable sender, Object event) {
        StockEvent e = new StockEvent(((StockEvent)event).getTicker(), ((StockEvent)event).getQuote());
        this.stockEvent = e;
        System.out.println("Ticker: " + e.getTicker());
        System.out.println("Quote: " + e.getQuote());
        System.out.println("Implemented Table");
    }
}