package org.example.stanford;

/**
 * RecIntMult
 *
 * Master Method :
 *
 * a = 4 :: Number of Recursive calls
 * b = 2 :: Factor smaller than input. Half the size of original array. Thus 2.
 * d = 1 :: Only calculations
 *
 *  This puts us on case 3 since a > b^d => 4 > 2^1 => O(n^log2 4) = > O(n^2)
 */
public class RecursiveMultiplier {


    public int multiply(int x, int y) {
        String xString = String.valueOf(x);

        if(xString.length() == 1) {
            return x*y;
        } else {
            int middle = xString.length() / 2;
            String yString = String.valueOf(y);
            int n = xString.length();

            String a = xString.substring(0,middle);
            String b = xString.substring(middle);

            String c = yString.substring(0,middle);
            String d = yString.substring(middle);

            int ac = multiply(Integer.valueOf(a),Integer.valueOf(c));
            int ad = multiply(Integer.valueOf(a),Integer.valueOf(d));
            int bc = multiply(Integer.valueOf(b),Integer.valueOf(c));
            int bd = multiply(Integer.valueOf(b),Integer.valueOf(d));

            return (int) ((Math.pow(10,n)*ac) + (Math.pow(10,n/2) * (ad+bc)) + bd);

        }
    }
}
