package org.example.stanford;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 3141592653589793238462643383279502884197169399375105820974944592
 *
 * 2718281828459045235360287471352662497757247093699959574966967627
 */
class KaratsubaMultiplicationTest {

    KaratsubaMultiplication karatsubaMultiplication = new KaratsubaMultiplication();
    TempKar tempKar = new TempKar();
    KaratsubaMultiplicationBD karatsubaMultiplicationBD = new KaratsubaMultiplicationBD();
    @Test
    void test() {
        try {
            long result = karatsubaMultiplication.karatsuba(5678,1234);
            System.out.println("Result = "+result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        long res2 = TempKar.karatsuba(5678,1234);
        System.out.println("res = "+res2);

    }

    @Test
    void test2(){
        BigInteger res = karatsubaMultiplicationBD.karatsuba(new BigInteger("3141592653589793238462643383279502884197169399375105820974944592"),new BigInteger("2718281828459045235360287471352662497757247093699959574966967627"));
        System.out.println("res = "+res.toString());

    }

}