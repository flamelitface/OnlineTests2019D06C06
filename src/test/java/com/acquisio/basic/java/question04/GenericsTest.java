package com.acquisio.basic.java.question04;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenericsTest {

    private final Generics generics = new Generics();

    @Test
    public void stockInventory() {
        assertEquals("Apple [red] : 50 units" + System.lineSeparator() + "Salad [Iceberg] : 19 units", generics.getStockInventory());
    }
}