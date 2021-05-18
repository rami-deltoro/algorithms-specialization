package org.example.usd;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class FibonacciTest {

    final Fibonacci fibonacci = new Fibonacci();

    @Test
    void testNaive() {
        System.out.println(fibonacci.naive(new BigInteger("20")));
    }

    @Test
    void testFaster() {
        System.out.println(fibonacci.faster(100));
    }
}