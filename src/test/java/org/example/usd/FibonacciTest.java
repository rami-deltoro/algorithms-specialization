package org.example.usd;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    final Fibonacci fibonacci = new Fibonacci();

    @Test
    void testNaive() {
        System.out.println(fibonacci.naive(new BigInteger("20")));
    }

    @Test
    void testFaster() {
        System.out.println(fibonacci.faster(new BigInteger("25")));
    }
}