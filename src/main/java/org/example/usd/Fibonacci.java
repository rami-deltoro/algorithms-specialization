package org.example.usd;

import java.math.BigInteger;


public class Fibonacci {

    public BigInteger naive(BigInteger bigInteger) {
        if(bigInteger.compareTo(BigInteger.ONE) <= 0) {
            return bigInteger;
        } else {
            BigInteger bigInteger1 = bigInteger.subtract(BigInteger.ONE);
            BigInteger bigInteger2 = bigInteger.subtract(BigInteger.TWO);

            return naive(bigInteger1).add(naive(bigInteger2));
        }
    }

    private BigInteger[] fibonacciNumbers;

    public BigInteger faster(int number) {
        fibonacciNumbers = new BigInteger[number+1];
        fibonacciNumbers[0] = BigInteger.ZERO;
        fibonacciNumbers[1] = BigInteger.ONE;

        for(int i=2;i<=number;i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i-1].add(fibonacciNumbers[i-2]);
        }

        return fibonacciNumbers[number];
    }

}
