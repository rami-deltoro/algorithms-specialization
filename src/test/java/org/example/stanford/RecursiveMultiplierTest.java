package org.example.stanford;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveMultiplierTest {

    final RecursiveMultiplier recursiveMultiplier = new RecursiveMultiplier();


    @Test
    void multiply() {
        System.out.println(recursiveMultiplier.multiply(5678,1234));
    }
}