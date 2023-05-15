package edu.umb.cs680.hw16_1;

public class LineChartObserver implements Observer<StockEvent>{
    private StockEvent stockEvent;

    public StockEvent getStockEvent() {
        return stockEvent;
    }

    @Override
    public void update(Observable<StockEvent> o, StockEvent event) {
        StockEvent e = new StockEvent((event).getTicker(), (event).getQuote());
        this.stockEvent = e;
        System.out.println("Ticker: " + e.getTicker());
        System.out.println("Quote: " + e.getQuote());
        System.out.println("Implemented Line Chart");
    }
}
