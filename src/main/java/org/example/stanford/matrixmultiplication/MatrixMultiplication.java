package org.example.stanford.matrixmultiplication;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MatrixMultiplication {

    public int[][] bruteForce(int[][] x, int[][] y) {
        int[][] result = new int[x.length][x.length];

        for(int i=0;i<x.length;i++) {
            for(int j=0;j<y.length;j++) {
                for(int k=0;k<y.length;k++) {
                    result[i][j] = result[i][j] + x[i][k]*y[k][j];
                }
            }
        }

        return result;
    }

    public int[][] divideAndConquerMatrixMultiplication(
            int[][] X, int[][] Y, int rowA, int colA,
            int rowB, int colB, int size){

        int[][] RESULT= new int[size][size];

        if(size==1)
            RESULT[0][0]= X[rowA][colA]*Y[rowB][colB];

        else{

            int newSize= size/2;

            int[][] AE = divideAndConquerMatrixMultiplication(X, Y, rowA, colA, rowB, colB, newSize);
            int[][] BG = divideAndConquerMatrixMultiplication(X, Y, rowA, colA+newSize, rowB+newSize, colB, newSize);
            sumMatrix(RESULT,AE,BG,0,0);


            int[][] AF = divideAndConquerMatrixMultiplication(X, Y, rowA, colA, rowB, colB + newSize, newSize);
            int[][] BH = divideAndConquerMatrixMultiplication(X, Y, rowA, colA+newSize, rowB+newSize, colB+newSize, newSize);
            sumMatrix(RESULT,AF,BH,0,newSize);

            int[][] CE = divideAndConquerMatrixMultiplication(X, Y, rowA+newSize, colA, rowB, colB , newSize);
            int[][] DG = divideAndConquerMatrixMultiplication(X, Y, rowA+newSize, colA+newSize, rowB+newSize, colB, newSize);
            sumMatrix(RESULT,CE,DG,newSize,0);

            int[][] CF = divideAndConquerMatrixMultiplication(X, Y, rowA+newSize, colA, rowB, colB+newSize , newSize);
            int[][] DH = divideAndConquerMatrixMultiplication(X, Y, rowA+newSize, colA+newSize, rowB+newSize, colB+newSize, newSize);
            sumMatrix(RESULT,CF,DH,newSize,newSize);

        }



        return RESULT;

    }


    private void sumMatrix(int[][] RESULT, int[][]A, int[][]B,int rowC, int colC){
        int n=A.length;
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++)
                RESULT[i+rowC][j+colC]=A[i][j]+B[i][j];
        }

    }




}
