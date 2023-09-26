package com.learning.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicAlgorithmsTest {

    @Test
    void helloWorldTest() {
        System.out.println("Hello World");
    }

    @Test
    void isEvenReturnsTrueTest() {
        // given
        final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();
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
        final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();
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
        final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();
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
        final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();
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
        final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();
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
        final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();
        final int number = -11;

        // when
        final boolean actual = basicAlgorithms.isPrime(number);

        // then
        assertFalse(actual);
    }

    @DisplayName("example of assertions")
    @Test
    void assertionsExamplesTest() {
        // given
        var someObject = BigDecimal.valueOf(100);
        var anotherObject = BigDecimal.valueOf(100);
        var basicAlgorithm = new BasicAlgorithms();

        // when
        // then
        assertTrue(true);
        assertFalse(false);
        assertNull(null);
        assertNotNull(someObject);
        assertEquals(someObject, anotherObject, "someObject is not equals to anotherObject");
        assertArrayEquals(new int[]{1, 3, 5}, new int[]{1, 3, 5});
        assertLinesMatch(List.of("line 1", "line 2", "line 3"), List.of("line 1", "line 2", "line 3"));
        assertNotEquals("some string", "another string");
        assertSame(someObject, someObject);
        assertNotSame(someObject, anotherObject);
        assertThrowsExactly(ArithmeticException.class, () -> {int x = 1 / 0;});
        assertThrows(RuntimeException.class, () -> {var x = 1 / 0;});
        assertDoesNotThrow(() -> {var x = 1/0.0;});
        assertTimeout(Duration.ofSeconds(3), () -> {basicAlgorithm.isPrime(34567890);});
        assertInstanceOf(BigDecimal.class, someObject);
        //fail("Method failed");
    }

    @DisplayName("given a positive number, when factorial is called, then returns its value")
    @Test
    void factorialTest() {
        // given
        final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();
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
        final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();
        final int number = -1;

        // when
        // then
        assertThrows(IllegalArgumentException.class,
                () -> {basicAlgorithms.factorial(number);});
    }
}