package org.example.stanford;

/**
 * RecIntMult
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
