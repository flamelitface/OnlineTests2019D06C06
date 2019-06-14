package com.acquisio.basic.java.question05;

import static org.junit.Assert.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RefactoringTest {

    private Item[] standardItemList;

    @Before
    public void init() {
        Item agedBrie = new Item("Aged Brie", 20, 10);
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 30, 10);
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 30, 0);
        Item standardItem = new Item("standardItem", 30, 10);
        Item conjuredItem = new Item("Conjured", 30, 10);

        standardItemList = new Item[]{agedBrie, sulfuras, backstagePasses, standardItem, conjuredItem};
    }

    @Test
    public void testName() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        Refactoring app = new Refactoring(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @Parameters({
            "1, 11, 19",
            "3, 13, 17",
            "20, 30, 0",
            "25, 40, -5",
            "28, 46, -8",
            "38, 50, -18"
    })
    public void testUpdateQualityForBrie(int iterations, int expectedQuality, int expectedSellIn) {
        Refactoring app = new Refactoring(standardItemList);

        updateQuality(app, iterations);

        assertEquals(expectedQuality, standardItemList[0].quality);
        assertEquals(expectedSellIn, standardItemList[0].sellIn);
    }

    @Test
    @Parameters({
            "1, 10, 30",
            "3, 10, 30",
            "20, 10, 30",
            "25, 10, 30",
            "28, 10, 30",
            "38, 10, 30"
    })
    public void testUpdateQualityForSulfuras(int iterations, int expectedQuality, int expectedSellIn) {
        Refactoring app = new Refactoring(standardItemList);

        updateQuality(app, iterations);

        assertEquals(expectedQuality, standardItemList[1].quality);
        assertEquals(expectedSellIn, standardItemList[1].sellIn);
    }

    @Test
    @Parameters({
            "1, 1, 29",
            "3, 3, 27",
            "20, 20, 10",
            "25, 30, 5",
            "28, 39, 2",
            "29, 42, 1",
            "30, 45, 0",
            "31, 0, -1"
    })
    public void testUpdateQualityForBackStagePasses(int iterations, int expectedQuality, int expectedSellIn) {
        Refactoring app = new Refactoring(standardItemList);

        updateQuality(app, iterations);

        assertEquals(expectedQuality, standardItemList[2].quality);
        assertEquals(expectedSellIn, standardItemList[2].sellIn);
    }

    @Test
    public void testUpdateQuality_backstagePasses_cannotExceedValueOf50() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 45)};
        Refactoring app = new Refactoring(items);

        updateQuality(app, 5);

        assertEquals(50, items[0].quality);
        assertEquals(5, items[0].sellIn);
    }

    @Test
    @Parameters({
            "1, 9, 29",
            "3, 7, 27",
            "20, 0, 10",
            "25, 0, 5",
            "28, 0, 2",
            "29, 0, 1",
            "30, 0, 0",
            "31, 0, -1"
    })
    public void testUpdateQualityForStandardItem(int iterations, int expectedQuality, int expectedSellIn) {
        Refactoring app = new Refactoring(standardItemList);

        updateQuality(app, iterations);

        assertEquals(expectedQuality, standardItemList[3].quality);
        assertEquals(expectedSellIn, standardItemList[3].sellIn);
    }

    @Test
    @Parameters({
            "1, 8, 29",
            "3, 4, 27",
            "20, 0, 10",
            "25, 0, 5",
            "28, 0, 2",
            "29, 0, 1",
            "30, 0, 0",
            "31, 0, -1"
    })
    public void testUpdateQualityForConjuredItem(int iterations, int expectedQuality, int expectedSellIn) {
        Refactoring app = new Refactoring(standardItemList);

        updateQuality(app, iterations);

        assertEquals(expectedQuality, standardItemList[4].quality);
        assertEquals(expectedSellIn, standardItemList[4].sellIn);
    }

    private void updateQuality(Refactoring app, int iterations) {
        for (int i = 0; i < iterations; i++) {
            app.updateQuality();
        }
    }

}