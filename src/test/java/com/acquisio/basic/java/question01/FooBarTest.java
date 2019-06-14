package com.acquisio.basic.java.question01;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FooBarTest {

    @Test
    @Parameters({
            "0, null, true",
            "1, 1, false",
            "2, 2, false",
            "3, Foo, false",
            "5, Bar, false",
            "6, Foo, false",
            "15, FooBar, false",
            "16, 16, false",
            "45, FooBar, false",
            "49, 49, false",
            "50, Bar, false",
            "10000, null, true"
    })
    public void testFooBar(int value, String expectedResult, boolean expectedException) {
        try {
            assertEquals(expectedResult, new FooBar().fooBar(value));
        } catch (IllegalArgumentException e) {
            if (expectedException) {
                assertEquals("This function only accepts an int between 1 and 50 inclusively", e.getMessage());
            }
        }
    }

}