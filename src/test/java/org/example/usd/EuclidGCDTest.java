package org.example.usd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EuclidGCDTest {

    private EuclidGCD euclidGCD = new EuclidGCD();

    @Test
    void test10_4() {
        int gcd = euclidGCD.calculate(10,4);
        assertEquals(gcd,2);
    }

    @Test
    void test357_234() {
        int gcd = euclidGCD.calculate(357,234);
        assertEquals(gcd,3);
    }

    @Test
    void testLargeNumber() {
        int gcd = euclidGCD.calculate(3918848,1653264);
        assertEquals(61232,gcd);
    }

}