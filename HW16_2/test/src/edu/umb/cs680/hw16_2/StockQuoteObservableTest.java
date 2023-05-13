package edu.umb.cs680.hw16_2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StockQuoteObservableTest {
    private static Observer<StockEvent> LineChartObserver = (Observable<StockEvent> sender, StockEvent event) -> {
        System.out.println("Stock Ticker: " + event.getTicker() + "\nStock Price: " + event.getQuote() + "\nLine Chart Observer changed");
    };

    private static Observer<StockEvent> TableObserver = (Observable<StockEvent> sender, StockEvent event) -> {
        System.out.println("Stock Ticker: " + event.getTicker() + "\nStock Price: " + event.getQuote() + "\nTable Observer changed.");
    };

    private static Observer<StockEvent> ThreeD_Observer = (Observable<StockEvent> sender, StockEvent event) -> {
        System.out.println("Stock Ticker: " + event.getTicker() + "\nStock Price: " + event.getQuote() + "\n3D Observer changed.");
    };

    private static StockQuoteObservable observable = new StockQuoteObservable();

    @BeforeAll
    public static void setUp(){
        observable.addObserver(LineChartObserver);
        observable.addObserver(TableObserver);
        observable.addObserver(ThreeD_Observer);
    }

    @Test
    public void verifyAddObserver(){
        assertFalse(observable.getObservers().isEmpty());
    }

    @Test
    public void verifyChangeObserver(){
        observable.changeQuote("NYSE", 15257.73);
        observable.changeQuote("DJI", 33279.73);
        }

    @Test
    public void verifyUpdateObserver(){
        observable.update(ThreeD_Observer, 35000);
    }

    @Test
    public void verifyRemoveObserver(){
        observable.removeObserver(LineChartObserver);
        observable.removeObserver(TableObserver);
        observable.removeObserver(ThreeD_Observer);
        assertTrue(observable.getObservers().isEmpty());
    }


}

