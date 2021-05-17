package org.example.usd;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

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

    final Map<BigInteger,BigInteger> resultMap = new HashMap<>();
    {
        resultMap.put(BigInteger.ZERO,BigInteger.ZERO);
        resultMap.put(BigInteger.ONE,BigInteger.ONE);
    }

    public BigInteger faster(BigInteger bigInteger) {
        if(bigInteger.compareTo(BigInteger.ONE) <= 0) {
            return bigInteger;
        } else {
            BigInteger result = resultMap.get(bigInteger);

            if(result == null) {
                System.out.println("Result is null for "+bigInteger);
                BigInteger bigInteger1 = bigInteger.subtract(BigInteger.ONE);
                BigInteger bigInteger2 = bigInteger.subtract(BigInteger.TWO);

                result =  naive(bigInteger1).add(naive(bigInteger2));
                resultMap.put(bigInteger,result);
            }


            return result;
        }
    }




    private BigInteger getResultFromMap(BigInteger bigInteger) {
        BigInteger bigIntegerToReturn = resultMap.get(bigInteger);
        if(bigIntegerToReturn==null) {
            bigIntegerToReturn = faster(bigInteger);
            resultMap.put(bigInteger,bigIntegerToReturn);
        }

        return bigIntegerToReturn;
    }
}
