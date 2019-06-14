package com.acquisio.basic.java.question07;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    @Test
    @Parameters({
            "1, 11, 12",
            "-4, 13, 9",
            "20, 30, 50",
            "2500, 440, 2940",
            "-2500, -440, -2940"
    })
    public void applyOperation_withAddition(int x, int y, Integer expectedResult) {
        assertEquals(expectedResult, Calculator.applyOperation(x, y, '+'));
    }

    @Test
    @Parameters({
            "1, 11, -10",
            "-4, 13, -17",
            "20, 30, -10",
            "2500, 440, 2060",
            "-2500, -440, -2060"
    })
    public void applyOperation_withSubtraction(int x, int y, Integer expectedResult) {
        assertEquals(expectedResult, Calculator.applyOperation(x, y, '-'));
    }

    @Test
    @Parameters({
            "1, 11, 11",
            "-4, 13, -52",
            "20, 30, 600",
            "2500, 440, 1100000",
            "-2500, -440, 1100000"
    })
    public void applyOperation_withMultiplication(int x, int y, Integer expectedResult) {
        assertEquals(expectedResult, Calculator.applyOperation(x, y, '*'));
    }

    @Test
    @Parameters({
            "10, 3, 3",
            "10, -3, -3",
            "2500, 440, 5",
            "-2500, -440, 5"
    })
    public void applyOperation_withDivision(int x, int y, Integer expectedResult) {
        assertEquals(expectedResult, Calculator.applyOperation(x, y, '/'));
    }

    @Test
    public void applyOperation_withDivision_returnsNullWhenDenominatorIsZero() {
        assertNull(null, Calculator.applyOperation(10, 0, '/'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void applyOperation_withInvalidCharacter_returnsIllegalArgumentException() {
        try {
            Calculator.applyOperation(10, 0, 'd');
        } catch (IllegalArgumentException e) {
            assertEquals("Operator 'd' not supported", e.getMessage());
            throw e;
        }
    }
}
