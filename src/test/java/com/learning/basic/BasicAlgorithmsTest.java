package com.learning.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicAlgorithmsTest {

    private final BasicAlgorithms basicAlgorithms = new BasicAlgorithms();

    @ParameterizedTest(name = "given {0} when isEven executes should return {1}")
    @MethodSource("isEvenArguments")
    void isEvenTest(final int number, final boolean expected) {
        // given
        // when
        final boolean actual = basicAlgorithms.isEven(number);

        // then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> isEvenArguments() {
        return Stream.of(
                Arguments.of(21, false),
                Arguments.of(22, true),
                Arguments.of(0, true)
        );
    }

    @ParameterizedTest(name = "given {0} when isPrime executes should return {1}")
    @MethodSource("isPrimeArguments")
    void isPrimeTest(final int number, final boolean expected) {
        // given
        // when
        final boolean actual = basicAlgorithms.isPrime(number);

        // then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> isPrimeArguments() {
        return Stream.of(
                Arguments.of(991, true),
                Arguments.of(0, false),
                Arguments.of(45678, false),
                Arguments.of(-991, false)
        );
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
        final int number = -1;

        // when
        // then
        assertThrows(IllegalArgumentException.class,
                () -> {
                    basicAlgorithms.factorial(number);
                });
    }
}