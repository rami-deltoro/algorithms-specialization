package org.example.stanford.matrixmultiplication;

import org.example.stanford.matrixmultiplication.MatrixMultiplication;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MatrixMultiplicationTest {

    MatrixMultiplication matrixMultiplication = new MatrixMultiplication();

    @Test
    void bruteForce() {
        int[][] x = new int[][]{{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
        int[][] y = new int[][]{{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};

        Arrays.stream(matrixMultiplication.bruteForce(x,y))
                .forEach(ints -> System.out.println(Arrays.toString(ints)));

        System.out.println("******************************");
        Arrays.stream(matrixMultiplication.divideAndConquerMatrixMultiplication(x,y,0,0,0,0,x.length))
                .forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
}