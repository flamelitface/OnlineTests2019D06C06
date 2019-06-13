package com.acquisio.basic.java.question03;

import org.junit.Test;

import static org.junit.Assert.*;

public class IssueResolvingTest {
    @Test
    public void factorial_returns5040_whenCalledWith7() {
        assertEquals(5040, new IssueResolving().factorial(7));
    }

    @Test
    public void factorial_returnsOne_whenCalledWithZero() {
        assertEquals(1, new IssueResolving().factorial(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorial_throwsException_whenCalledWithNumberTooHigh() {
        try {
            new IssueResolving().factorial(13);
        } catch (IllegalArgumentException e) {
            assertEquals("This method only accepts positive integers between 1 and 12", e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorial_throwsException_whenCalledWithNegativeNumber() {
        try {
            new IssueResolving().factorial(-1);
        } catch (IllegalArgumentException e) {
            assertEquals("This method only accepts positive integers between 1 and 12", e.getMessage());
            throw e;
        }
    }

}