package com.acquisio.basic.java.question03;

/**
 * QUESTION 04: StackOverflow
 * This program crashes after throwing StackOverflowError exception:
 * Fix the factorial method.
 *
 * IMPORTANT: Add all missing javadoc and/or unit tests that you think is necessary.
 */
public class IssueResolving {
    public static void main(String[] args) {
        IssueResolving instance = new IssueResolving();
        System.out.println(instance.factorial(7));
    }

    /**
     * This method accepts and returns and int.
     * Due to overflow issues, this method only operates for values between 0 and 12
     * @param n must be between 0 and 12
     * @return n factorial
     */
    int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("This method only accepts positive integers between 1 and 12");
        }
        if(n == 0) {
            return 1;
        }
        int result = 0;
        result = factorial(n - 1) * n;
        return result;
    }

}
