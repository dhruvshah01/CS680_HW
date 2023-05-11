package edu.umb.cs680.hw16_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StockQuoteObservableTest {
    private static LineChartObserver l = new LineChartObserver();
    private static ThreeD_Observer t3 = new ThreeD_Observer();
    private static TableObserver t = new TableObserver();
    private static StockQuoteObservable observable = new StockQuoteObservable();

    @BeforeAll
    public static void setUp(){
        observable.addObserver(l);
        observable.addObserver(t3);
        observable.addObserver(t);
    }
    @Test
    public void verifyAddObserver(){
        assertFalse(observable.getObservers().isEmpty());
    }

    @Test
    public void verifyChangeObserver(){
        observable.changeQuote("NYSE", 15257.73);
        assertEquals("NYSE", l.getStockEvent().getTicker());
        assertEquals("NYSE", t3.getStockEvent().getTicker());
        assertEquals("NYSE", t.getStockEvent().getTicker());


        observable.changeQuote("DJI", 33279.73);
        assertEquals(33279.73, l.getStockEvent().getQuote());
        assertEquals(33279.73, t3.getStockEvent().getQuote());
        assertEquals(33279.73, t.getStockEvent().getQuote());
    }

    @Test
    public void verifyRemoveObserver(){
        observable.removeObserver(l);
        observable.removeObserver(t3);
        observable.removeObserver(t);
        assertTrue(observable.getObservers().isEmpty());
    }
}
