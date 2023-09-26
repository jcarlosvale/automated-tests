package com.learning.basic;

import java.util.List;

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

    public int countOccurrencesOfANumber(final int [] numbers, final int number) {
        int count = 0;
        for(int i : numbers) {
            if (i == number) {
                count++;
            }
        }
        return count;
    }

    public int linearSearch(final List<Integer> listOfNumbers, final int number) {

        for(int index = 0; index < listOfNumbers.size(); index++) {
            if (listOfNumbers.get(index) == number) {
                return index;
            }
        }

        return -1;
    }
}
