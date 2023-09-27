package com.learning.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LifeCycle {

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll executed\n");
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach executed");
    }

    @Test
    void someTest() {
        System.out.println("SomeTest executed");
    }

    @Test
    void anotherTest() {
        System.out.println("AnotherTest executed");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach executed\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll executed");
    }
}
