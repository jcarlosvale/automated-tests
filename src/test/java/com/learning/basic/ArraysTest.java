package com.learning.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArraysTest {

    private static String[] elements;

    @BeforeAll
    static void beforeAll() {
        elements = new String[3];
    }

    @AfterAll
    static void afterAll() {
        elements = null;
    }

    @BeforeEach
    void setUp() {
        elements[0] = "RED";
        elements[1] = "BLUE";
        elements[2] = "GREEN";
    }

    @AfterEach
    void tearDown() {
        elements[0] = "";
        elements[1] = "";
        elements[2] = "";
    }

    @Test
    void sortArrayTest() {
        // given
        var expected = new String[]{"BLUE", "GREEN", "RED"};

        // when
        var actual = Arrays.stream(elements).sorted().toArray(String[]::new);

        // then
        assertArrayEquals(expected, actual);
    }

    @Test
    void naiveTest() {
        // given
        var expected = new String[]{"RED", "BLUE", "GREEN"};

        // when
        var actual = elements;

        // then
        assertArrayEquals(expected, actual);
    }
}
