package com.acquisio.basic.java.question01;

import org.springframework.util.StringUtils;

/**
 * QUESTION 01: FooBar
 * You have a program that loop from 1 to 50.
 * <p>
 * The program must follow those rules:
 * - Must print 'Foo' if the value can be divided by 3.
 * - Must print 'Bar' if the value can be divided by 5.
 * - Otherwise, print the current integer value in the loop.
 *
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
public class FooBar {
    public static void main(String[] args) {
        FooBar main = new FooBar();
        for (int i = 1; i <= 50; i ++) {
            System.out.println(main.fooBar(i));
        }
    }

    String fooBar(int value) {
        if (value > 50 || value < 1) {
            throw new IllegalArgumentException("This function only accepts an int between 1 and 50 inclusively");
        }

        StringBuilder sb = new StringBuilder();
        if (value % 3 == 0) {
            sb.append("Foo");
        }
        if (value % 5 == 0) {
            sb.append("Bar");
        }

        String result = sb.toString();

        if(StringUtils.isEmpty(result))
            return String.valueOf(value);

        return result;
    }
}
