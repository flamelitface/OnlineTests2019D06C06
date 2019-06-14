package com.acquisio.basic.java.question06;

import org.junit.Test;

import static org.junit.Assert.*;

public class DebuggingTest {
    @Test
    public void removeEvenNumbers() {
        assertArrayEquals(new Integer[]{1, 3}, new Debugging().removeEvenNumbers(1, 2, 3, 4));
    }

}