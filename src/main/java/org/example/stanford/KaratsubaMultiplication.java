package org.example.stanford;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Master Method :
 *
 * a = 3 :: Number of Recursive calls
 * b = 2 :: Factor smaller than input. Half the size of original number. Thus 2.
 * d = 1 :: Only calculations
 *
 *  This puts us on case 3 since a > b^d => 3 = 2^1 => O(n^log2 3) = > O(n^1.59)
 */
@Slf4j
public class KaratsubaMultiplication {



    // An exponent function. Works the same way as Math.pow, but with 64bit integers instead of double precision floats.
    public static long power(long x, long y) {
        if (y == 0)
            return 1;
        else {
            long answer = 1;
            for (int i = 1; i<=y; i++) {
                answer *= x;
            }
            return answer;
        }
    }

    /*
     * Take two numbers, x and y.
     * Example: 12345 and 6789.
     * Find a base b and power m to separate it into.
     * We'll pick base = 10, and m to be half the length of the digits of the numbers in this implementation of the algorithm.
     * 	In this case, m will be 2, so 10^2 = 100. We will split the 2 numbers using this multiplier.
     * The form we want is:
     * x = x1*b^m + x0
     * y = y1*b^m + y0
     * ----------
     * Using the above example,
     * x1 = 123
     * x0 = 45
     * ----------
     * y1 = 67
     * y2 = 89
     * ----------
     * b = 10 and m = 2
     * ----------
     * Thus:
     * 12345 = 123 * 10^2  +  45
     * 6789 =   67 * 10^2  +  89
     *
     *
     * The recursive algorithm is as follows:
     *
     * If x<10 or y<10, return x*y. Single digit multiplication is the base case.
     * Otherwise:
     * Let z2 = karatsuba(x1, y1). x1 and y1 are the most significant digits, and are the local variables "high".
     * Let z0 = karatsuba(x0, y0). x0 and y0 are the least significant digits, and are the local variables "low".
     * Let z1 = karatsuba(x1+y0, x0+y1) - z0 - z2.
     * And the result is the following sum:
     * z2 * b^2m	+	z1 * b^m	+	z0
     *
     * @param x The multiplicand.
     * @param y The multiplier.
     * @return The product.
     */

    public static long karatsuba(long x, long y) {
        // Base case: single digit multiplication
        if (x<10 || y<10) {
            return x * y;
        }
        // Recursive case: Decompose the problem by splitting the integers and applying the algorithm on the parts.
        else {
            // Convert the numbers to strings so we can compute the # of digits of each number.
            // Note: We could also use floor(log10(n) + 1) to compute the #digits, but remember that we need to split the numbers too.
            String xString = Integer.toString((int)x);
            String yString = Integer.toString((int)y);
            // Local variables
            int 	m = Math.max(xString.length(), yString.length()); // the maximum # of digits
            int        m2 = m/2; // the middle; if the number is odd, it will floor the fraction
            int xM2 = m2;
            int yM2 = m2;

            if(xString.length() % 2 != 0) {
                xM2++;
            }
            if(yString.length() % 2 != 0) {
                yM2++;
            }

            String  high1 = xString.substring(0,xM2);//Integer.parseInt(strCopy(m2, xString)[0]), // the most significant digits. this is the scalar multiplier for b^m2
            String  low1 = xString.substring(xM2); // the least significant digits. this is what is added on to high1*b^m2
            String  high2 = yString.substring(0,yM2); // same for y
            String  low2 = yString.substring(yM2);// same for y
                    //log.info("high1 = {} low1= {} high2 = {} low2= {} xString = {} yString = {} m2 = {}, m/2 = {}",high1,low1,high2,low2,xString,yString,m2,(m/2));
            long    z0 = karatsuba(Long.valueOf(low1),Long.valueOf(low2)); // z0 = x0y0
            long    z2 = karatsuba(Long.valueOf(high1), Long.valueOf(high2)); // z2 = x1y1
            long    z1 = karatsuba((Long.valueOf(low1) + Long.valueOf(high1)), (Long.valueOf(low2) + Long.valueOf(high2))) - z2 - z0; // z1 = (x0 + y1)*(x1 + y0) - z2 - z0, courtesy of Karatsuba
            log.info("high1 = {} low1= {} high2 = {} low2= {} xString = {} yString = {} m2 = {}, m/2 = {} z0={},z1={},z2={}",high1,low1,high2,low2,xString,yString,m2,(m/2),z0,z1,z2);

            return (z2 * power(10, 2*m2) + (z1 * power(10, m2)) + z0);
        }
    }
}
