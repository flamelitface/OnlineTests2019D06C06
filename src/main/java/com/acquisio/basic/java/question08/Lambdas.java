package com.acquisio.basic.java.question08;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * QUESTION 08: Lambdas (https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
 * Using JDK8 Lambdas, add the code to transform the input file to apply those rules.
 * 1- Keep lines where the amount is greater than or equals to 50$
 * 2- Add a Taxes column right after the Amount column, which is 15% of the Amount.
 * 3- Add a Total column right after the Taxes column, which is the sum of Amount and Taxes.
 * 4- Remove the ShoppingCartTitle columns.
 * <p>
 * The input file contains those columns
 * User,Amount,ShoppingCartTitle,NbItems
 * <p>
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */

public class Lambdas {

    private final double TAX_PERCENTAGE = 0.15;
    private final String separator = System.lineSeparator();

    public static void main(String[] args) throws IOException, URISyntaxException {
        Lambdas instance = new Lambdas();
        File input = new File(Thread.currentThread().getContextClassLoader().getResource("./carts.csv").toURI());
        File output = new File("./carts_output.csv");
        output.delete();

        instance.convertCarts(input, output);

        if (output.exists()) {
            Files.lines(output.toPath()).forEachOrdered(line -> System.out.println(line));
        }
    }

    void convertCarts(File input, File output) throws IOException {
        String outputLines = Files
                .lines(input.toPath())
                .map(line -> line.split(","))
                .filter(lineArray -> Double.valueOf(lineArray[1]) >= 50L)
                .map(lineArray -> new ArrayList<>(Arrays.asList(lineArray)))
                .peek(lineList -> lineList.remove(2))
                .peek(lineList -> lineList.add(2, String.valueOf(TAX_PERCENTAGE * Double.valueOf(lineList.get(1)))))
                .peek(lineList -> lineList.add(3, String.valueOf(Double.valueOf(lineList.get(2)) + Double.valueOf(lineList.get(1)))))
                .peek(lineList -> lineList.add(separator))
                .flatMap(Collection::stream)
                .collect(Collectors.joining(","));

        outputLines = outputLines.replaceAll(separator + ",", separator);
        outputLines = outputLines.substring(0, outputLines.length() - separator.length() - 1);

        Files.write(output.toPath(), outputLines.getBytes());
    }


}
