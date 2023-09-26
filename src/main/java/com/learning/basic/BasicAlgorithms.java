package com.learning.basic;

public class BasicAlgorithms {

    public boolean isEven(final int number) {
        return number % 2 == 0;
    }

    public boolean isPrime(final int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= (number / 2); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int factorial(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number should not be negative");
        } else {
            if (n <= 1) {
                return 1;
            } else {
                return n * factorial(n-1);
            }
        }
    }
}
