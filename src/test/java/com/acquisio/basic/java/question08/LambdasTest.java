package com.acquisio.basic.java.question08;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class LambdasTest {
    @Test
    public void convertCarts() throws Exception {
        Lambdas instance = new Lambdas();
        File input = new File(Thread.currentThread().getContextClassLoader().getResource("./carts.csv").toURI());
        File output = new File("./carts_output.csv");
        output.delete();

        instance.convertCarts(input, output);

        assertTrue(output.exists());
        String result = FileUtils.readFileToString(output);
        String[] resultArray = result.split(System.lineSeparator());
        assertEquals(3, resultArray.length);
        assertEquals(5, resultArray[0].split(",").length);
        assertEquals("John Doe,100.00,15.0,115.0,3," + System.lineSeparator() +
                        "Suzanne D.,150.00,22.5,172.5,18," + System.lineSeparator() +
                        "New Car,19000.00,2850.0,21850.0,1",
                result);
    }

    @Test
    public void convertCartsWithSingleLine() throws Exception {
        Lambdas instance = new Lambdas();
        File input = new File(Thread.currentThread().getContextClassLoader().getResource("./cartsWithSingleLine.csv").toURI());
        File output = new File("./carts_output.csv");
        output.delete();

        instance.convertCarts(input, output);

        assertTrue(output.exists());
        String[] result = FileUtils.readFileToString(output).split(System.lineSeparator());
        assertEquals(1, result.length);
        assertEquals("John Doe,100.00,15.0,115.0,3", result[0]);
    }

}