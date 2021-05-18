package org.example.usd;


public class EuclidGCD {


    public int calculate(int a, int b) {
        if(b==0) {
            return a;
        }

        int remainderA = a % b;

        return calculate(b,remainderA);
    }
}
