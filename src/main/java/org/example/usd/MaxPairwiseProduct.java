package org.example.usd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {

    public static long getMaxPairwiseProductNaive(int[] numbers) {
        long product = 0;

        for(int i=0;i<numbers.length;i++) {
            for(int j=i+1;j<numbers.length;j++) {
                product = Math.max(product, (long) numbers[i] * numbers[j]);
            }
        }

        if(numbers.length==1) {
            product = (long) numbers[0] * numbers[0];
        }

        return product;
    }

    public static long getMaxPairwiseProduct(int[] numbers) {
        int firstLargestIndex = 0;
        int secondLargestIndex = 1;
        int n = numbers.length;

        for(int i=1;i<n;i++) {
            if(numbers[firstLargestIndex] < numbers[i]) {
                firstLargestIndex = i;
            }
        }

        swap(numbers,0,firstLargestIndex);

        for(int i=1;i<n;i++) {
            if(numbers[secondLargestIndex] < numbers[i]) {
                secondLargestIndex = i;
            }
        }



        swap(numbers,1,secondLargestIndex);




        return (long) numbers[0] *numbers[1];
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
