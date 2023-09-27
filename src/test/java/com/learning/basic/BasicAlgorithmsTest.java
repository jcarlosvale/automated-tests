package com.learning.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicAlgorithmsTest {

    private final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();

    @Test
    void isEvenReturnsTrueTest() {
        // given
        final int evenNumber = 222;
        final boolean expected = true;

        // when
        final boolean actual = basicAlgorithms.isEven(evenNumber);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("given an odd number, when isEven is called, then returns false")
    @Test
    void isEvenReturnsFalseTest() {
        // given
        final int evenNumber = 111;
        final boolean expected = false;

        // when
        final boolean actual = basicAlgorithms.isEven(evenNumber);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("given a prime number, when isPrime is called, then returns true")
    @Test
    void isPrimeReturnsTrueTest() {
        // given
        final int number = 11;

        // when
        final boolean actual = basicAlgorithms.isPrime(number);

        // then
        assertTrue(actual);
    }

    @DisplayName("given a number that is not prime, when isPrime is called, then returns false")
    @Test
    void isPrimeReturnsFalseTest() {
        // given
        final int number = 432;

        // when
        final boolean actual = basicAlgorithms.isPrime(number);

        // then
        assertFalse(actual);
    }

    @DisplayName("given a number equals to 0, when isPrime is called, then returns false")
    @Test
    void isPrimeReturnsFalseToZeroValueTest() {
        // given
        final int number = 0;

        // when
        final boolean actual = basicAlgorithms.isPrime(number);

        // then
        assertFalse(actual);
    }

    @DisplayName("given a negative number, when isPrime is called, then returns false")
    @Test
    void isPrimeReturnsFalseToNegativeValueTest() {
        // given
        final int number = -11;

        // when
        final boolean actual = basicAlgorithms.isPrime(number);

        // then
        assertFalse(actual);
    }

    @DisplayName("given a positive number, when factorial is called, then returns its value")
    @Test
    void factorialTest() {
        // given
        final int number = 5;
        final int expected = 120;

        // when
        final var actual = basicAlgorithms.factorial(number);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("given a negative number, when factorial is called, then throws an exception")
    @Test
    void factorialExceptionTest() {
        // given
        final int number = -1;

        // when
        // then
        assertThrows(IllegalArgumentException.class,
                () -> {basicAlgorithms.factorial(number);});
    }
}